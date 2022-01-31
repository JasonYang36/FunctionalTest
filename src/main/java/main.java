import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();

        RuleEngine engine = (RuleEngine)context.getBean("ruleEngine");

        System.out.println(main.class.getPackage().getName());
    }
}
