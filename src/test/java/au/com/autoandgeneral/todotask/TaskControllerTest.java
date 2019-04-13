package au.com.autoandgeneral.todotask;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest(classes = TodoTaskApplication.class, properties = "server.port:0", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {
    @Value("${local.server.port:-1}")
    private int port;

    @PostConstruct
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:" + port;
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void testValidateBrackets() {
        RestAssured
                .get("/tasks/validateBrackets?input=(")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("input", equalTo("("))
                .body("isBalanced", equalTo(false));
    }

}
