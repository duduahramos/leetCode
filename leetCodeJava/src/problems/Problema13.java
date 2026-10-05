package problems;

import java.util.ArrayList;

//https://leetcode.com/problems/roman-to-integer/
public class Problema13 {
    public static int romanToInt(String s) {
        var valorInvertido = inverteString(s);
        var numeroAnterior = 0;
        var numeroFinal = 0;

        var i = 0;
        while (i <= valorInvertido.length()) {
            var charAtual = i < valorInvertido.length() ? String.valueOf(valorInvertido.charAt(i)) : "";
            var numeroAtual = switchRomanToInt(charAtual);

            if (numeroAtual < numeroAnterior) {
                numeroFinal += (numeroAnterior - numeroAtual);

                numeroAnterior = 0;
            } else {
                numeroFinal += numeroAnterior;

                numeroAnterior = numeroAtual;
            }

            i++;
        }

        return numeroFinal;
    }

    private static int switchRomanToInt(String s) {
        int resultado = switch (s) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;

            default -> 0;
        };

        return resultado;
    }

    private static String inverteString(String valorStr) {
        var valorInvertido = "";

        var index = valorStr.length() - 1;

        while (index >= 0) {
            valorInvertido += valorStr.charAt(index);
            index--;
        }

        return valorInvertido;
    }
}
