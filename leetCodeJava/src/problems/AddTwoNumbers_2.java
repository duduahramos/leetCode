package problems;

import problems.models.ListNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var somaLista1 = somaLista(l1);
        var somaLista2 = somaLista(l2);
        var listasSomadas = somaLista1 + somaLista2;

        var listasSomadasStr = Integer.toString(listasSomadas);

        ListNode listaFinal = null;
        ListNode listaLoop = null;

        for (var numero : List.of(listasSomadasStr.split("")).reversed()) {
            var listNode =  new ListNode(Integer.parseInt(numero));

            if (listaFinal == null) {
                listaFinal = listNode;
                listaLoop = listNode;
            }
            else {
                listaLoop.next = listNode;
                listaLoop = listaLoop.next;
            }
        }

        return listaFinal;
    }

    private static int somaLista(ListNode lista) {
        int soma = 0;

        int potencia = 0;

        while (true) {
            var valor = (int) (lista.val * Math.pow(10, potencia));

            soma += valor;

            if (lista.next == null)
                break;

            lista = lista.next;
            potencia += 1;
        }

        return soma;
    }
}