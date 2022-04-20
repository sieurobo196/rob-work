package codewr.com.spring.boot.service;

import codewr.com.spring.boot.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Long id);
    public User saveUser(User user);
    public boolean deleteUser(User user);
    public String testCallPostCallBack() throws JsonProcessingException;
    public String testCallPost() throws IOException;
}
