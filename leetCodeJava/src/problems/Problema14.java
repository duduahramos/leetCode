package problems;

import java.util.*;

//https://leetcode.com/problems/longest-common-prefix/
public class Problema14 {
    public static String longestCommonPrefix(String[] strs) {
        var qtdPalavras = strs.length;

        if (qtdPalavras == 1)
            return strs[0];

        var prefixos = new HashMap<Integer, String>();

        var indexDeCorte = 0;

        var pararLoop = false;

        while (!pararLoop) {
            String prefixo = null;
            var qtdMatch = 0;

            for (var i = 0; i < qtdPalavras; i++) {
                var palavraAtual = strs[i];

                if (indexDeCorte > palavraAtual.length()) {
                    pararLoop = true;
                    break;
                } else {
                    if (prefixo == null)
                        prefixo = palavraAtual.substring(0, indexDeCorte);
                    if (prefixo.equalsIgnoreCase("")) {
                        continue;
                    }
                }

                var prefixoAtual = palavraAtual.substring(0, indexDeCorte);

                if (prefixo.equalsIgnoreCase(prefixoAtual))
                    qtdMatch++;
            }

            prefixos.put(qtdMatch, prefixo);

            indexDeCorte++;
        }

        var prefixoComum = prefixos.get(qtdPalavras);

        return prefixoComum != null ? prefixoComum : "";
    }
}
