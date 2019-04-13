package au.com.autoandgeneral.todotask.exception;

import au.com.autoandgeneral.todotask.model.BalanceTestResult;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private BalanceTestResult balanceTestResult;
}
