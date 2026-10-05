package problems;

//https://leetcode.com/problems/palindrome-number/
public class Problem9 {
    public static boolean isPalindrome(int x) {
        var valorStr = String.valueOf(x);
        var valorInvertido = inverteString(valorStr);

        return valorStr.equals(valorInvertido);
    }

    private static String inverteString(String valor) {
        var valorInvertido = "";

        int index = valor.length() - 1;

        while (index >= 0) {
            valorInvertido += valor.charAt(index);
            index--;
        }

        return valorInvertido;
    }
}
