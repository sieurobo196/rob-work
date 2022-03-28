package codewr.com.spring.bean;

import codewr.com.spring.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Service là một annotation, nó được sử dụng để chú thích trên một class để nói với Spring rằng class đó là một Spring BEAN.
public class GreetingService {

    @Autowired
//    @Autowired được chú thích trên một trường (field) để nói với Spring rằng hãy tiêm (inject) giá trị vào cho trường đó.
//    Chú ý: Từ tiêm ở đây có ý giống với gán giá trị cho trường đó.
    private Language language;

    public GreetingService() {

    }

    public void sayGreeting() {

        String greeting = language.getGreeting();

        System.out.println("Greeting: " + greeting);
    }
//    Không có sự khác biệt về cách sử dụng của @Service, @Component và @Repository,
//    bạn sử dụng để chú thích trên các class của bạn nên phù hợp với ý nghĩa và ngữ cảnh trong ứng dụng.
}