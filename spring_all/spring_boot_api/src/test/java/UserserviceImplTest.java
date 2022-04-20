import codewr.com.spring.boot.model.User;
import codewr.com.spring.boot.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.matcher.ElementMatchers;
import okhttp3.internal.http2.Header;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class UserserviceImplTest {
    @InjectMocks
    private UserServiceImpl userService;


    private static final String CUSTOMER_PATH = "/rest/api/v3/customer/";
    public static final String API_KEY = "123456Akjnknk&%";
    private MockWebServer mockWebServer;
    private ObjectMapper objectMapper;
    private HttpClient httpClient;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(); //initialise mock web server
    }
    @Test
    public void test() throws IOException {
        objectMapper = mock(ObjectMapper.class);
        User user1 = User.builder().id(1).username("admin").age(20).build();
//        Mockito.when(objectMapper.writeValueAsString(user1)).thenReturn("" +
//                "{\n" +
//                "        \"id\": 3,\n" +
//                "        \"username\": \"admin1\",\n" +
//                "        \"age\": 20\n" +
//                "    }");
        userService.testCallPost();
        Assertions.assertEquals(true,true);
    }


}
