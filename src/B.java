public class B {
    @AliceInject
    private A a;
    public String foofoo() {
        return a.foo();
    }
}
