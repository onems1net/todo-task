package au.com.autoandgeneral.todotask.api;

import au.com.autoandgeneral.todotask.model.BalanceTestResult;
import au.com.autoandgeneral.todotask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping(path = "/validateBrackets", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<BalanceTestResult> validateBrackets(@RequestParam(value = "input") String input) {
        return new ResponseEntity<BalanceTestResult>(taskService.validateBrackets(input),HttpStatus.OK);
    }
}
