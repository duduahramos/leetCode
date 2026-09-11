package problems;

import problems.models.ListNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listaFinal = new ListNode(0); // essa lista(0) sera ignorada pois no final é retornado listaFinal.next
        ListNode listaAtual = listaFinal; // cria uma referencia auxiliar
        int digitoExtraSomaAnterior = 0;

        while (l1 != null || l2 != null || digitoExtraSomaAnterior != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int soma = val1 + val2 + digitoExtraSomaAnterior;

            digitoExtraSomaAnterior = soma / 10; // exemplo: 18 / 10 = 1,8 | ao atribuir a uma var INT, var = 1
            int digitoAtual = soma % 10;// exemplo: 18 % 10 = 8 | sobra 8 da divisão, então o digito atual é 8, e o 1 sera somado na proxima volta do laço

            listaAtual.next = new ListNode(digitoAtual); //
            listaAtual = listaAtual.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return listaFinal.next;
    }


    public static ListNode addTwoNumbers_old(ListNode l1, ListNode l2) {
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