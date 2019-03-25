package zheyan.com.a;

import zheyan.com.b.B;
import zheyan.com.tools.AliceInject;

public class A {
    @AliceInject
    private B b;

    public String foo() {
        return "I'm A.";
    }
    public String foofoofoo() {
        return b.foofoo();
    }


}
