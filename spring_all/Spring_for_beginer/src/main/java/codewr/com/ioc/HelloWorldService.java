package codewr.com.ioc;

// Và một class dịch vụ
public class HelloWorldService {

    // Một trường có kiểu codewr.com.ioc.HelloWorld
    private HelloWorld helloWorld;

    // Cấu tử tạo đối tượng codewr.com.ioc.HelloWorldService
    // Nó khởi tạo giá trị cho trường 'helloWorld'
    public HelloWorldService()  {
        this.helloWorld = new StrutsHelloWorld();
    }

//    Có thể nhận thấy một điều rằng lớp codewr.com.ioc.HelloWorldService quản lý việc tạo ra đối tượng codewr.com.ioc.HelloWorld.
//
//   Trong trường hợp trên khi một đối tượng codewr.com.ioc.HelloWorldService được tạo ra từ phương thức khởi tạo (constructor) của nó, đối tượng codewr.com.ioc.HelloWorld cũng được tạo ra, và nó được tạo từ codewr.com.ioc.StrutsHelloWorld.
//    Câu hỏi đặt ra là bạn muốn tạo ra đối tượng codewr.com.ioc.HelloWorldService đồng thời đối tượng codewr.com.ioc.HelloWorld được tạo, nhưng nó phải là codewr.com.ioc.SpringHelloWorld.
//
//    Như vậy ở đây là codewr.com.ioc.HelloWorldService đang điều khiển "object creation" của codewr.com.ioc.HelloWorld. Tại sao chúng ta không chuyển việc tạo codewr.com.ioc.HelloWorld cho một bên thứ 3 xử lý thay vì làm ở codewr.com.ioc.HelloWorldService. Chúng ta có khái niệm "inversion of control" nghĩa là "Sự đảo ngược điều khiển" (IoC).
//    Và IoC Container sẽ đóng vai trò người quản lý việc tạo ra cả codewr.com.ioc.HelloWorldService lẫn codewr.com.ioc.HelloWorld.

}