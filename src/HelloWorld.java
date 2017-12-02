public class HelloWorld {
    String name = "";

    public HelloWorld(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, World to " + name);
    }

    public void callBackToKot() {
        HelloKt.printSum(10, 20);
    }
}
