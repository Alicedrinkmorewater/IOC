import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    public final Map<String, Class<?>> beanClassMap = new HashMap<>();
    public final Map<String, Object> beanInstanceMap = new HashMap<>();

    public void register(Class x) {
        try {
            beanClassMap.put(x.getName(), x);
            beanInstanceMap.put(x.getName(), x.newInstance());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            for (Map.Entry<String, Object> entry : beanInstanceMap.entrySet()) {
                Class<?> clazz = beanClassMap.get(entry.getKey());
                Object obj = entry.getValue();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(AliceInject.class)) {
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = beanInstanceMap.get(fieldClazz.getName());
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object get(Class x) {
        return beanInstanceMap.get(x.getName());
    }

}
