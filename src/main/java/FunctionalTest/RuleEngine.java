package FunctionalTest;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RuleEngine {
    public <T> void executeRule(Function<T, Boolean> rule, String value){
        System.out.println(rule.apply((T) value));
    }
}
