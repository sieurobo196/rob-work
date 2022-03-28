package codewr.com.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component là một annotation, nó được chú thích trên một class để nói với Spring rằng class này là một Spring BEAN.

public class MyComponent {

    @Autowired
//    @Autowired được chú thích trên một trường (field) để nói với Spring rằng hãy tiêm (inject) giá trị vào cho trường đó.
//    Chú ý: Từ tiêm ở đây có ý giống với gán giá trị cho trường đó.
    private MyRepository repository;

    public void showAppInfo() {
        System.out.println("Now is: "+ repository.getSystemDateTime());
        System.out.println("App Name: "+ repository.getAppName());
    }

}