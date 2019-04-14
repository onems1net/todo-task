package com.animesh.todotask.api;

import com.animesh.todotask.model.BalanceTestResult;
import com.animesh.todotask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test/1.0/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping(path = "/validateBrackets", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<BalanceTestResult> validateBracketsGet(@RequestParam(value = "input") String input) {
        return new ResponseEntity<BalanceTestResult>(taskService.validateBrackets(input),HttpStatus.OK);
    }

    @PostMapping(value = "/validateBrackets",consumes = MediaType.TEXT_PLAIN_VALUE,produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<BalanceTestResult> validateBracketsPost(@RequestBody String input) {
        return new ResponseEntity<BalanceTestResult>(taskService.validateBrackets(input),HttpStatus.OK);
    }
}
