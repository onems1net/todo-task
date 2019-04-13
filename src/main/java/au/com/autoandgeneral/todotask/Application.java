package au.com.autoandgeneral.todotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        System.out.println("character encoding filter called");
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceRequestEncoding(true);
        return characterEncodingFilter;
    }
}
