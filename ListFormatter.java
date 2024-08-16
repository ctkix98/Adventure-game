import java.util.List;
import java.util.stream.Collectors;

public class ListFormatter {

    //To delete [] and coma when displaying arrays in the game
    public static String formatList(List<?> list) {
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
