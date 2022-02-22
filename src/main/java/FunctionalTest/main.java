package FunctionalTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        RuleEngine engine = (RuleEngine)context.getBean("ruleEngine");

        CheckBlank func = new CheckBlank();

        String empty = "";
        String notEmpty = "not an empty string";

        System.out.println("Using RuleEngine");
        engine.executeRule(func, empty);
        engine.executeRule(func, notEmpty);

        System.out.println();
        System.out.println("Using Lambda Functions");
        engine.executeRule((s) -> {
                    if (s == null) return true;
                    if (s instanceof String){
                        return ((String) s).isEmpty();
                    }
                    else return false;
                },
                empty);

        engine.executeRule((s) -> {
                    if (s == null) return true;
                    if (s instanceof String){
                        return ((String) s).isEmpty();
                    }
                    else return false;
                },
                notEmpty);
    }
}