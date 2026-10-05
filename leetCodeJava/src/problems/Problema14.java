package problems;

import java.util.*;

//https://leetcode.com/problems/longest-common-prefix/
public class Problema14 {
    public static String longestCommonPrefix(String[] strs) {
        var prefixoComum = "";

        var tabelaPalavras = new ArrayList<List<String>>();

        for (var i = 0; i < strs.length; i++) {
            tabelaPalavras.add(new ArrayList<>());

            var palavra = strs[i];
            var letras = palavra.split("");

            for (String letra : letras) {
                tabelaPalavras.get(i).add(letra);
            }
        }

        var colunaFinal = 0;
        while (true) {
            var 

            for (var palavra : tabelaPalavras) {

            }

            colunaFinal++;
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
