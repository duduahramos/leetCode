package problems;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class Problem4_IA {
    // 1, 3
    // 2
    // O(log(2 + 1)) -> O(log3) -> log2^3 = 8
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] menorArray = nums1;
        int[] maiorArray = nums2;

        if (nums2.length < nums1.length) {
            menorArray = nums2;
            maiorArray = nums1;
        }

        int tamanhoMenor = menorArray.length;
        int tamanhoMaior = maiorArray.length;

        // Quantos elementos, no total (dos dois arrays somados), devem ficar
        // do lado esquerdo do corte. Ex: tamanho_menor=2, tamanho_maior=4 (total=6)
        // → metade_esquerda=3, ou seja, juntando os elementos à esquerda dos dois
        // cortes (corte_menor + corte_maior), a soma tem que dar 3.
        // O +1 garante que, se o total for ímpar, a esquerda fica com 1 elemento
        // a mais (convenção usada depois para achar a mediana direto, sem cálculo extra)
        int metadeEsquerda = (tamanhoMenor + tamanhoMaior + 1) / 2;

        int corteMin = 0;
        int corteMax = tamanhoMenor;

        while (corteMin <= corteMax) {
            // Passo 1: corteMenor é uma POSIÇÃO entre elementos de menor_array
            int corteMenor = (corteMin + corteMax) / 2;

            // Passo 2: corteMaior é derivado de corte_menor, não escolhido
            int corteMaior = metadeEsquerda - corteMenor;

            // Maior elemento do lado esquerdo do corte em menorArray.
            // Se corteMenor == 0, não há elementos à esquerda, então usa MIN_VALUE
            // (garante que essa "esquerda vazia" nunca vai violar a condição de corte válido)
            int esquerdaMenor;
            if (corteMenor > 0) {
                esquerdaMenor = menorArray[corteMenor - 1];
            } else {
                esquerdaMenor = Integer.MIN_VALUE;
            }

            // Menor elemento do lado direito do corte em menorArray.
            // Se corteMenor == tamanhoMenor, não há elementos à direita (corte no final do array),
            // então usa MAX_VALUE (garante que essa "direita vazia" nunca vai violar a condição)
            int direitaMenor;
            if (corteMenor < tamanhoMenor) {
                direitaMenor = menorArray[corteMenor];
            } else {
                direitaMenor = Integer.MAX_VALUE;
            }

            // Maior elemento do lado esquerdo do corte em maiorArray.
            // Mesma lógica: corteMaior == 0 significa nada à esquerda nesse array
            int esquerdaMaior;
            if (corteMaior > 0) {
                esquerdaMaior = maiorArray[corteMaior - 1];
            } else {
                esquerdaMaior = Integer.MIN_VALUE;
            }

            // Menor elemento do lado direito do corte em maiorArray.
            // Mesma lógica: corteMaior == tamanhoMaior significa nada à direita nesse array
            int direitaMaior;
            if (corteMaior < tamanhoMaior) {
                direitaMaior = maiorArray[corteMaior];
            } else {
                direitaMaior = Integer.MAX_VALUE;
            }

            // Passo 3: corte válido = ninguém da esquerda é maior que alguém da direita
            if (esquerdaMenor <= direitaMaior && esquerdaMaior <= direitaMenor) {
                int total = tamanhoMenor + tamanhoMaior;
                if (total % 2 == 0) {
                    return (Math.max(esquerdaMenor, esquerdaMaior) + Math.min(direitaMenor, direitaMaior)) / 2.0;
                }
                return Math.max(esquerdaMenor, esquerdaMaior);
            }

            // Passo 4: direção do ajuste, sempre determinística (por isso busca binária funciona)
            else if (esquerdaMenor > direitaMaior) {
                corteMax = corteMenor - 1; // esquerdaMenor alto demais, move corte pra esquerda
            } else {
                corteMin = corteMenor + 1; // esquerdaMaior alto demais, move corte pra direita
            }
        }

        throw new IllegalArgumentException("nums1 e nums2 precisam estar ordenados");
    }
}
