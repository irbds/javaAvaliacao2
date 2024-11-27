/*Calculadora de raiz quadrada*/
/*
Crie um programa onde o usuario digite um numero e seja calculada a raiz quadrada desse numero.
Caso o numero seja negativo, deve ser lançada uma exception e o programa deve ser finalizado
*/

import java.util.Scanner;
public class Parte2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        try{
            System.out.print("Digite qualquer numero: ");
            double numero = scanner.nextDouble();

            if( numero < 0){
                throw new IllegalArgumentException("Não é possivel tirar a raiz quadrade de numeros negativos!");
            }
            double raiz = Math.sqrt(numero);
            System.out.println("A raiz de " + numero + " e: " + raiz);
            System.out.println();
        }
        catch(IllegalArgumentException e) {
            System.out.println("Deu erro: " + " " + e.getMessage());
        }
        
        finally {
            System.out.println("Processo feito e concluido!");
            scanner.close();
        }
        }
    }

