package problems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

//                 mjvhmi
//Sliding Window
public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        String sequenciaUnica = "";

        int i = 0;
        int posicaoInicial = 0;
        int maiorSequencia = 0;

        while (i < s.length()) {
            if (!sequenciaUnica.contains(s.substring(i, i + 1))) {
                sequenciaUnica = s.substring(posicaoInicial, i + 1);
                i++;

                if (sequenciaUnica.length() > maiorSequencia)
                    maiorSequencia = sequenciaUnica.length();

                continue;
            }

            sequenciaUnica = "";
            posicaoInicial++;
            i = posicaoInicial;
        }

        return maiorSequencia;
    }
}
