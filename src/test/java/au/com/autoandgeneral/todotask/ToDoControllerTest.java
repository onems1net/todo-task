package au.com.autoandgeneral.todotask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest(classes = Application.class, properties = "server.port:0", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerTest {
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
    public void testGetWithInvalidId() {
        RestAssured
                .get("/todo/5")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void testGetWithoutId() {
        RestAssured
                .get("/todo")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void testAdd() {
        Map map = new HashMap();
        map.put("text", "Task-1");
        map.put("completed", false);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .post("/todo/add")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("text", equalTo("Task-1"))
                .body("completed", equalTo(false))
                .body("createdAt", notNullValue())
                .body("updatedAt", notNullValue());
    }

    @Test
    public void testPatch() {
        Map map = new HashMap();
        map.put("text", "Task-1");
        map.put("completed", true);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .patch("/todo/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("text", equalTo("Task-1"))
                .body("completed", equalTo(true))
                .body("createdAt", notNullValue())
                .body("updatedAt", notNullValue());
    }

    @Test
    public void testPatchWithInvalidId() {
        Map map = new HashMap();
        map.put("text", "Task-1");
        map.put("completed", true);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .patch("/todo/5")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testPatchWithoutId() {
        Map map = new HashMap();
        map.put("text", "Task-1");
        map.put("completed", true);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .when()
                .patch("/todo")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
