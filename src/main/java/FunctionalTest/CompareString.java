package FunctionalTest;

import java.util.function.Function;

public class CompareString implements Function<String, Boolean> {
    private final String predefinedString;

    public CompareString(String toCompare){
        predefinedString = toCompare;
    }

    @Override
    public Boolean apply(String s) {
        if (s == null) return false;
        else if (s.compareTo(predefinedString) >= 0) return true;
        else return false;
    }
}
