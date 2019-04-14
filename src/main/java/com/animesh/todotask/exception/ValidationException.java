package com.animesh.todotask.exception;

import com.animesh.todotask.model.BalanceTestResult;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private BalanceTestResult balanceTestResult;
}
