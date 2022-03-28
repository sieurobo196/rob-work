package codewr.com.spring.bean;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
//@Repository là một annotation, nó được sử dụng để chú thích trên một class để nói với Spring rằng class này là một Spring BEAN.
public class MyRepository {

    public String getAppName() {
        return "Hello Spring App";
    }

    public Date getSystemDateTime() {
        return new Date();
    }


}