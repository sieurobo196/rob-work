package codewr.com.spring;


import codewr.com.spring.bean.GreetingService;
import codewr.com.spring.bean.MyComponent;
import codewr.com.spring.config.AppConfiguration;
import codewr.com.spring.lang.Language;
import codewr.com.spring.lang.impl.Vietnamese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProgram {

    public static void main(String[] args) {
        // Tạo ra một đối tượng ApplicationContext bằng cách đọc cấu hỉnh trong class AppConfiguration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("----------");
        Language language = (Language) context.getBean("language");

        System.out.println("Bean Language: " + language);
        System.out.println("Call language.sayBye(): " + language.getBye());

        System.out.println("----------");

        GreetingService service = (GreetingService) context.getBean("greetingService");


        service.sayGreeting();

        System.out.println("----------");

        MyComponent myComponent = (MyComponent) context.getBean("myComponent");

        myComponent.showAppInfo();

//        Nguyên tắc hoạt động của Spring
//        Bạn tạo một đối tượng ApplicationContext bằng cách đọc các cấu hình trong class AppConfiguration, giống như đoạn code dưới đây.
//       1. Spring sẽ tạo các Spring BEAN, theo các định nghĩa trong class AppConfiguration, (Chú ý: Class AppConfiguration phải được chú thích bởi @Configuration).
//         cụ thể ở đây là bean language
//       2.Tiếp theo Spring sẽ tìm kiếm trong package "org.o7planning.spring.bean" để tạo các Spring BEAN khác, (Tạo các đối tượng từ các class được chú thích bởi @Service, @Component hoặc @Repository).
//         cụ thể là các bean greetingService, myComponent, MyRepository
//       3.Lúc này các Spring BEAN đã được tạo ra, và được chứa trong Spring IoC. Các trường của các Spring BEAN có chú thích bởi @Autowired sẽ được tiêm các giá trị vào:
//        language có Vietnamese , greetingService có language, myComponent có MyRepository

//        Trở về với câu hỏi "IoC là gì?".
//        Theo cách truyền thống một đối tượng được tạo ra từ một class, các trường (field) của nó sẽ được gán giá trị từ chính bên trong class đó.
//        Spring đã làm ngược lại với cách truyền thống, các đối tượng được tạo ra và một vài trường của nó được tiêm giá trị từ bên ngoài vào bởi một cái được gọi là IoC.
//
//        IoC viết tắt của "Inversion of Control" - Có nghĩa là "Đảo ngược của sự điều khiển".
//        IoC Container là bộ chứa tất cả các Spring BEAN được sử dụng trong ứng dụng
    }

}