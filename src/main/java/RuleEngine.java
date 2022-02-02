import org.springframework.stereotype.Component;

import java.util.function.Function;

public class RuleEngine {
    public void executeRule(Function<String, Boolean> rule, String value){
        System.out.println(rule.apply(value));
    }
}
