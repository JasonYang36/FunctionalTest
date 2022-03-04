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

        System.out.println("Testing CheckBlank");
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

        System.out.println("-------------------------------------");
        System.out.println("Testing CompareString");
        String stringToCompare = "abc";

        String abc = "abc";
        String somethingElse = "something else";
        String a = "a";
        CompareString func2 = new CompareString(stringToCompare);
        System.out.println("Using class object");
        engine.executeRule(func2, abc);
        engine.executeRule(func2, somethingElse);
        engine.executeRule(func2, a);

        System.out.println("Using Lambda Functions");
        engine.executeRule((s) -> {
                    if (s == null) return false;
                    else if (s instanceof String) {
                        if (((String) s).compareTo(stringToCompare) >= 0) return true;
                        else return false;
                    } else return false;
                },
                abc);
        engine.executeRule((s) -> {
                    if (s == null) return false;
                    else if (s instanceof String) {
                        if (((String) s).compareTo(stringToCompare) >= 0) return true;
                        else return false;
                    } else return false;
                },
                somethingElse);
        engine.executeRule((s) -> {
                    if (s == null) return false;
                    else if (s instanceof String) {
                        if (((String) s).compareTo(stringToCompare) >= 0) return true;
                        else return false;
                    } else return false;
                },
                a);
    }
}