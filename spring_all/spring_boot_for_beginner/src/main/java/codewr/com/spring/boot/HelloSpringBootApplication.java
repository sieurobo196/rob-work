package codewr.com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Chú thích @SpringBootApplication là tương đương với việc sử dụng @Configuration, @EnableAutoConfiguration và @ComponentScan với các thuộc tính mặc định của chúng.
//Như vậy @SpringBootApplication giúp bạn tự động cấu hình Spring, và tự động quét (Scan) toàn bộ project để tìm ra các thành phần Spring (Controller, Bean, Service,...)
public class HelloSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
}
