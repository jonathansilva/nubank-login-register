package app.project.loginregister.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PatternHelper {
    static boolean pattern(String pattern, String string) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(string);
        return matcher.matches();
    }
}
