package au.com.autoandgeneral.todotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoTaskApplication {
    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "{}");
        SpringApplication.run(TodoTaskApplication.class, args);
    }
}
