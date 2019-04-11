package au.com.autoandgeneral.todotask.api;

import au.com.autoandgeneral.todotask.model.BalanceTestResult;
import au.com.autoandgeneral.todotask.util.Parentheses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task/")
public class TaskController {
    @GetMapping("/validateBrackets/{input}")
    public BalanceTestResult validateBrackets(@PathVariable("input") String input) {
        boolean isBalanced = Parentheses.isBalanced(input);

        return new BalanceTestResult(input, isBalanced);
    }
}
