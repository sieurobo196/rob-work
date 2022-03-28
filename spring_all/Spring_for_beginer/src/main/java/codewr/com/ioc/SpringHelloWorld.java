package codewr.com.ioc;

import codewr.com.ioc.HelloWorld;

// Class thi hành interface codewr.com.ioc.HelloWorld
public class SpringHelloWorld implements HelloWorld {
    public void sayHello() {
        System.out.println("Spring say Hello!");
    }
}
