package codewr.com.ioc;


public class HelloWorldServiceWithIOC {

    private HelloWorld helloWorld;

    public HelloWorldServiceWithIOC() {
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

//    IoC Container tạo ra đối tượng HelloWorldServiceWithIOC và đối tượng HelloWorld
//    sau đó pass HelloWorld vào HelloWorldServiceWithIOC thông qua setter.
//    Việc IoC Container đang làm chính là "tiêm sự phụ thuộc" (Dependency Injection) vào HelloWorldService .
//    Sự phụ thuộc ở đây nghĩa là sự phụ thuộc giữa các object : HelloWorldService và HelloWorld.
//
//    Tới đây ta đã xác định được rõ thế nào là IoC&DI. Hãy cùng làm ví dụ HelloWorld để hiểu rõ hơn.
}