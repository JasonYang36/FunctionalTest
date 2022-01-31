import java.util.function.Function;

public class CheckBlank implements Function<String, Boolean> {

    @Override
    public Boolean apply(String s) {
        if (s == null) return true;
        else return s.isEmpty();
    }
}
