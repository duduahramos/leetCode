package problems;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/
public class Problema14 {
    public static String longestCommonPrefix(String[] strs) {
        var prefixoComum = "";

        if (strs.length == 1)
            return strs[0];

        for (var index1 = 0; index1 < strs.length; index1++) {
            var palavra1 = strs[index1];

            var index2 = 0;

            var corteFinal1 = 1;
            while (corteFinal1 < palavra1.length() && index2 < strs.length) {
                var palavra2 = strs[index2];

                if (palavra2.equalsIgnoreCase(palavra1)) {
                    index2++;
                    continue;
                }

                var prefixo1 = palavra1.substring(0, corteFinal1);

                var corteFinal2 = 1;
                while (corteFinal2 < palavra2.length()) {
                    var prefixo2 = palavra2.substring(0, corteFinal2);

                    if (prefixo1.equalsIgnoreCase(prefixo2) && prefixo1.length() > prefixoComum.length()) {
                        prefixoComum = prefixo1;
                    }

                    corteFinal2++;
                }

                index2++;
                corteFinal1++;
            }

        }

        return prefixoComum;
    }

    public static String longestCommonPrefix_OLD(String[] strs) {
        int corteFinal = 0;
        var prefixoComum = "";
        int indexPalavra = 0;
        var x = 0;

        while (x < strs.length) {
            var palavraAtual = strs[indexPalavra];

            if (palavraAtual.length() <= 0)
                return prefixoComum;

            corteFinal = palavraAtual.length() - 1;
            var prefixo = palavraAtual.substring(0, corteFinal);
            var prefixo2 = strs[x].substring(0, corteFinal);

            if (prefixo.equalsIgnoreCase(prefixo2)) {
                prefixoComum = prefixo;
            } else {
                if ((corteFinal + 1) >= palavraAtual.length()) {
                    indexPalavra++;
                    corteFinal = 0;
                } else {
                    x = 0;
                    corteFinal++;
                }
            }

            x++;
        }

        return prefixoComum;
    }
}
