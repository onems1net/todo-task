package au.com.autoandgeneral.todotask.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ValidationError {
    private List<ValidationDetail> validationDetails;
}
