import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();

        RuleEngine engine = new RuleEngine();

//        RuleEngine engine = (RuleEngine)context.getBean("ruleEngine");

        CheckBlank func = new CheckBlank();

        String empty = "";
        String notEmpty = "not an empty string";

        engine.executeRule(func, empty);
    }
}
