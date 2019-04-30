package zheyan.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zheyan.com.tools.AliceInject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContainerGenericType {

    Logger logger = LoggerFactory.getLogger(DIContainer.class);
    public final Map<Class<?>, Object> beanInstanceMap = new HashMap<>();

    public void register(Class x) {
        try {
            logger.info("TEST");
            beanInstanceMap.put(x, x.newInstance());
        } catch (IllegalAccessException iae) {
            logger.error(iae.getMessage());

        } catch (InstantiationException  ie) {
        }


        try {
            for (Map.Entry<Class<?>, Object> entry : beanInstanceMap.entrySet()) {
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(AliceInject.class)) {
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = beanInstanceMap.get(fieldClazz);
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public <E> E get(Class x) {
        return (E)beanInstanceMap.get(x);
    }
}
