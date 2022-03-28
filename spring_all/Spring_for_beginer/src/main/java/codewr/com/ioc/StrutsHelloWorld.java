package codewr.com.ioc;

import codewr.com.ioc.HelloWorld;

// Một class khác thi hành Interface codewr.com.ioc.HelloWorld
public class StrutsHelloWorld implements HelloWorld {
    public void sayHello() {
        System.out.println("Struts say Hello!");
    }
}
