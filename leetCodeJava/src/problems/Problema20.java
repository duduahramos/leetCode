package problems;

import java.util.ArrayList;
import java.util.Map;

//https://leetcode.com/problems/valid-parentheses/
public class Problema20 {
    // '()[]{}'
    // '([])'
    private static final Map<String, Boolean> parenteses = Map.of(
            "(", true,
            "[", true,
            "{", true,
            ")", false,
            "]", false,
            "}", false
    );

    private static final Map<String, String> parentesesFecha = Map.of(
            ")", "(",
            "]", "[",
            "}", "{"
    );

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        var pilhaAberta = new ArrayList<String>();

        for (var idx = 0; idx < s.length(); idx++) {
            var caractere = String.valueOf(s.charAt(idx));

            if (parenteses.get(caractere)) {
                pilhaAberta.add(caractere);
            } else {
                if (pilhaAberta.isEmpty())
                    return false;

                if (parentesesFecha.get(caractere).equalsIgnoreCase(pilhaAberta.getLast())) {
                    pilhaAberta.removeLast();
                } else {
                    return false;
                }
            }
        }

        return pilhaAberta.isEmpty();
    }
}
