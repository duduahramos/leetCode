package problems;

import java.util.*;

//https://leetcode.com/problems/longest-common-prefix/
public class Problema14 {
    public static String longestCommonPrefix(String[] strs) {
        var prefixoComum = "";

        if (strs.length == 1)
            return strs[0];

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        if (strs[0].length() == 0 || "".equalsIgnoreCase(strs[0]))
            return prefixoComum;

        var achou = false;

        var colunaFinal = strs[0].length() > 0 ? strs[0].length() : 1;

        //IDEIA: CRIAR DICIONARIO COM PREFIXO E QTD DE VEZES QUE REPETE

        while (colunaFinal >= 0 && !achou) {
            var prefixo1 = strs[0].substring(0, colunaFinal);

            var colunaFinal2 = colunaFinal;
            for (var i = 1; i < strs.length; i++) {
                var prefixo2 = strs[i].substring(0, colunaFinal2);

                if (!prefixo1.equals(prefixo2)) {
                    colunaFinal2--;
                    continue;
                }
                prefixoComum = prefixo1;

                if (i == (strs.length - 1))
                    achou = true;
            }
            colunaFinal--;
        }

        return prefixoComum;
    }
}
