package com.animesh.todotask.service;

import com.animesh.todotask.exception.ValidationException;
import com.animesh.todotask.model.BalanceTestResult;
import com.animesh.todotask.model.ValidationDetail;
import com.animesh.todotask.model.ValidationError;
import com.animesh.todotask.util.Parentheses;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Service("taskService")
public class TaskService {
    public BalanceTestResult validateBrackets(String input) {
        if (StringUtils.isEmpty(input) || input.length() > 50) {
            ValidationDetail validationDetail = new ValidationDetail("params", "input", "Input length be between 1 and 50 characters long", input);

            throw new ValidationException(new BalanceTestResult(input, false, new ValidationError(Arrays.asList(validationDetail))));
        }

        return new BalanceTestResult(input, Parentheses.isBalanced(input), null);
    }
}
