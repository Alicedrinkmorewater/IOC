
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DIContainer container = new DIContainer();
        container.register(B.class);
        container.register(A.class);

        B b = (B)container.get(B.class);
        A a = (A)container.get(A.class);
        System.out.println(b.foofoo());
        System.out.println(a.foofoofoo());
    }
}
