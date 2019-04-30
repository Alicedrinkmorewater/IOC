package zheyan.com.b;

import zheyan.com.a.A;
import zheyan.com.tools.AliceInject;

public class B {
    @AliceInject
    private A a;
    
    public String foofoo() {
        return a.foo();
    }
}
