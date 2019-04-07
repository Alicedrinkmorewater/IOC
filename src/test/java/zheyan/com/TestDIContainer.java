package zheyan.com;

import org.junit.Assert;
import org.junit.Test;
import zheyan.com.a.A;
import zheyan.com.b.B;

public class TestDIContainer {
    @Test
    public void testGetClass() {
        zheyan.com.DIContainer container = new zheyan.com.DIContainer();
        container.register(B.class);
        container.register(A.class);

        B b = (B)container.get(B.class);
        A a = (A)container.get(A.class);
        Assert.assertEquals(b.foofoo(), a.foofoofoo());
    }

    @Test
    public void testGetClassGenericType() {
        zheyan.com.DIContainerGenericType container = new zheyan.com.DIContainerGenericType<Object>();
        container.register(B.class);
        container.register(A.class);

        B b = (B)container.get(B.class);
        A a = (A)container.get(A.class);
        Assert.assertEquals(b.foofoo(), a.foofoofoo());
    }
}
