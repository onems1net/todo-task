package au.com.autoandgeneral.todotask.model;


import lombok.Value;

@Value
public class ValidationDetail {
    private String location;
    private String param;
    private String message;
    private String value;
}
