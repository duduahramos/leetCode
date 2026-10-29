package problems;

import java.util.ArrayList;
import java.util.HashMap;
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
    private static final Map<String, String> parentesesAbreFecha = Map.of(
            "(", ")",
            "[", "]",
            "{", "}",
            ")", "(",
            "]", "[",
            "}", "{"
    );

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        var pilhaAberta = new ArrayList<String>();
        var pilhaFecha = new ArrayList<String>();

        for (var idx = 0; idx < s.length(); idx++) {
            var caractere = String.valueOf(s.charAt(idx));

            if (parenteses.get(caractere)) {
                //pilhaAberta.add(0, caractere);
                pilhaAberta.add(caractere);
            } else {
                //pilhaFecha.add(0, caractere);
                //pilhaFecha.add(caractere);
            }
        }

        for (var idx = 0; idx < pilhaAberta.size(); idx++) {
            var abre = pilhaAberta.get(idx);
            var fecha = pilhaFecha.get(idx);
            var deParaAbreFecha = parentesesAbreFecha.get(abre);

            if (!fecha.equalsIgnoreCase(deParaAbreFecha))
                return false;
        }

        return true;
    }
}
