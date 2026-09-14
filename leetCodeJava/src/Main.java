import problems.Problem2;
import problems.models.ListNode;
import problems.Problem3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // PROBLEM 2 ---------------------------------------------------------------------------------------------------
        var lista1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var lista2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var resultadoLista = Problem2.addTwoNumbers(lista1, lista2);

        lista1 = new ListNode(9);
        lista2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))));

        resultadoLista = Problem2.addTwoNumbers(lista1, lista2);

        System.out.println(resultadoLista);

        // PROBLEM 3 ---------------------------------------------------------------------------------------------------
        String valorStr = null;
        int resultInt = 0;


//        valorStr = "abcabcbb";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);
//
//        valorStr = "bbbbb";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);
//
//        valorStr = "pwwkew";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);
//
//        valorStr = "a";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);
//
//        valorStr = "1R1T7";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);

//        valorStr = "mjvhmi";
//        resultInt = Problem3.lengthOfLongestSubstring(valorStr);

        valorStr = "eea";
        resultInt = Problem3.lengthOfLongestSubstring(valorStr);
    }
}