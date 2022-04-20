package codewr.com.spring.boot.controller;

import codewr.com.spring.boot.model.User;
import codewr.com.spring.boot.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getAllEmployees() {
        return userService.findAll();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {

        User user = userService.findById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long userId,
                                               @RequestBody User user) {
        User user1 = userService.findById(userId);
        user1.setUsername(user.getUsername());
        user1.setAge(user.getAge());

        final User updatedEmployee = userService.saveUser(user);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) {

        User user = userService.findById(userId);

        userService.deleteUser(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    @GetMapping("test")
    public String testcallPost() throws IOException {
        return userService.testCallPost();
    }

    @GetMapping("test-callback")
    public String testcallPostCallBack() throws JsonProcessingException {
        return userService.testCallPostCallBack();
    }
}
