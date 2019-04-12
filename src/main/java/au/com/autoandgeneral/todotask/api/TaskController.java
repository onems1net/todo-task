package au.com.autoandgeneral.todotask.api;

import au.com.autoandgeneral.todotask.model.BalanceTestResult;
import au.com.autoandgeneral.todotask.util.Parentheses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @GetMapping(path = "/validateBrackets",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public BalanceTestResult validateBrackets(@RequestParam(value = "input") String input) {
        boolean isBalanced = Parentheses.isBalanced(input);

        return new BalanceTestResult(input, isBalanced);
    }
}
