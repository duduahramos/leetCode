package problems;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/
public class Problema14 {
    public static String longestCommonPrefix(String[] strs) {
        var prefixoComum = "";

        if (strs.length == 1)
            return strs[0];
        var index1 = 0;
        while (index1 < strs.length) {
            var palavra1 = strs[index1];
            var corteFinal1 = palavra1.length() - 1;

            while (corteFinal1 > 0) {
                var prefixo1 = palavra1.substring(0, corteFinal1);

                var index2 = 0;
                while (index2 < strs.length) {
                    var palavra2 = strs[index2];
                    var corteFinal2 = palavra2.length() - 1;

                    if (index1 != index2) {
                        while (corteFinal2 > 0) {
                            var prefixo2 = palavra2.substring(0, corteFinal2);

                            if (prefixo1.equals(prefixo2) && prefixo1.length() > prefixoComum.length()) {
                                prefixoComum = prefixo1;
                            }

                            corteFinal2--;
                        }
                    }

                    index2++;
                }

                corteFinal1--;
            }

            index1++;
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
