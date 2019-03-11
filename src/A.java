

public class A {
    @AliceInject
    private B b;
    String foo() {
        return "I'm A.";
    }
    String foofoofoo() {
        return b.foofoo();
    }


}
