import problems.AddTwoNumbers_2;
import problems.models.ListNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 2
        var lista1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var lista2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var result = AddTwoNumbers_2.addTwoNumbers(lista1, lista2);

        System.out.println(result);
    }
}