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
    public @ResponseBody
    ResponseEntity<BalanceTestResult> validateBrackets(@RequestParam(value = "input") String input) {
        /*if (StringUtils.isEmpty(input) || input.length() > 50) {
            ValidationDetail validationDetail = new ValidationDetail("params", "input", "Input length be between 1 and 50 characters long", input);

            throw new ValidationException(new BalanceTestResult(input, false, new ValidationError(Arrays.asList(validationDetail))));
        }

        return new ResponseEntity<BalanceTestResult>(new BalanceTestResult(input, Parentheses.isBalanced(input), null), HttpStatus.OK);*/

        return new ResponseEntity<BalanceTestResult>(taskService.validateBrackets(input),HttpStatus.OK);
    }
}
