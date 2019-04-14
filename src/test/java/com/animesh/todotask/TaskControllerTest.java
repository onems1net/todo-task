package com.animesh.todotask;

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

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest(classes = Application.class, properties = "server.port:0", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {
    @Value("${local.server.port:-1}")
    private int httpPort;

    @PostConstruct
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:" + httpPort;
        RestAssured.port = httpPort;
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    public void testValidateBracketsUnBalanaced() {
        RestAssured
                .get("/test/1.0/tasks/validateBrackets?input=(")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("input", equalTo("("))
                .body("balanced", equalTo(false));

    }

    @Test
    public void testValidateBracketsBalanaced() {
        RestAssured
                .get("/test/1.0/tasks/validateBrackets?input=()")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("input", equalTo("()"))
                .body("balanced", equalTo(true));
    }

    @Test
    public void testValidateBracketsInputLength() {
        RestAssured
                .get("/test/1.0/tasks/validateBrackets?input=")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .and()
                .body("validationError.validationDetails", hasSize(greaterThan(0)));
    }

    @Test
    public void testValidateBraceUnBalanaced() {
        RestAssured
                .get("/test/1.0/tasks/validateBrackets?input={")
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("input", equalTo("{"))
                .body("balanced", equalTo(false));
    }
}
