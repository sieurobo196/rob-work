package codewr.com.spring.boot.service.impl;

import codewr.com.spring.boot.model.User;
import codewr.com.spring.boot.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.*;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;

    public UserServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<User> findAll() {
        List<User> listAlluser = new ArrayList<>();
        User user1 = User.builder().id(1).username("admin").age(20).build();
        User user2 = User.builder().id(2).username("user").age(23).build();
        listAlluser.add(user1);
        listAlluser.add(user2);
        return listAlluser;
    }

    @Override
    public User findById(Long id) {
        User user1 = User.builder().id(1).username("admin").age(20).build();
        return user1;
    }

    @Override
    public User saveUser(User user) {
        User user1 = User.builder().id(1).username("admin").age(20).build();
        return user1;
    }

    @Override
    public boolean deleteUser(User user) {
        User user1 = User.builder().id(1).username("admin").age(20).build();
        return true;
    }

    @Override
    public String testCallPostCallBack() throws JsonProcessingException {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        User user1 = User.builder().id(1).username("admin").age(20).build();
        String payload = objectMapper.writeValueAsString(user1);
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(payload, JSON);
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/v1/users")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(body)
                .build();

        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            int count = 0;

            public void onResponse(Call call, Response response)
                    throws IOException {
                String reponseBody = response.body().string();
                log.info("checkDebitAccount reponse: {}", reponseBody);
                if (response.code() == 200) {
//                    checkDebitAccountInfo(reponseBody, messageDto);
                } else if (response.code() == 400) {
//                    handleGetDebitAccountNotFound(messageDto);
                }
            }

            public void onFailure(Call call, IOException e) {
                log.info("checkDebitAccount reponse: fail{}", e);
                if (count < 3) {
                    try {
                        Thread.sleep(1000);
//                        handleGetDebitAccountTimeout(messageDto);
                        retryCall();
                        count++;
                    } catch (InterruptedException ex) {
                        log.error("checkDebitAccount error InterruptedException");
                    }

                } else {
//                    handleGetDebitAccountTimeoutExceeded(messageDto);
                }

            }

            private void retryCall() {
                log.info("checkDebitAccount Retrying -" + count + " -- " + new Date());
                call.clone().enqueue(this);
            }
        });
        return "call ok";
    }

    @Override
    public String testCallPost() throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        User user1 = User.builder().id(1).username("admin").age(20).build();
        String payload = objectMapper.writeValueAsString(user1);
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(payload, JSON);
        Request request = new Request.Builder()
                .url("http://localhost:8080/api/v1/users")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(body)
                .build();

        Response response = httpClient.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        return "call ok";
    }
}
