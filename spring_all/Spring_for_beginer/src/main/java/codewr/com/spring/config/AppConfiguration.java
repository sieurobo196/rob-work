package codewr.com.spring.config;

import codewr.com.spring.lang.Language;
import codewr.com.spring.lang.impl.English;
import codewr.com.spring.lang.impl.Vietnamese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Configuration là một annotation, nó được chú thích trên một class, class này sẽ định nghĩa các Spring BEAN.
@ComponentScan({"codewr.com.spring.bean"})
//@ComponentScan - Nói cho Spring các package để tìm kiếm các Spring BEAN khác, Spring sẽ quét (scan) các package đó để tìm kiếm.
public class AppConfiguration {

    @Bean(name ="language")
    public Language getLanguage() {

        return new English();
    }

}