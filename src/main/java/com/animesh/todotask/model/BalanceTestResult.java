package com.animesh.todotask.model;

import lombok.Value;

@Value
public class BalanceTestResult {
    private String input;
    private boolean isBalanced;
    private ValidationError ValidationError;
}
