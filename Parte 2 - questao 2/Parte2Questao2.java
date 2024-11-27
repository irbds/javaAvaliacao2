/*Crie um programa que simule uma bolsa, essa bolsa pode armazenar até 5 itens quaisquer
 * sera possivel remover e adicionar itens na bolsa, alem de visualizar a bolsa
 * caso o usuario tente adicionar um item em um slot que já possui item, deve retornar um erro
 * caso o usuario tente remover um item em um slot que não possui item, deve retornar um erro
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parte2Questao2 {
    static Scanner sc = new Scanner(System.in);
    static int escolha;

    public static void main(String[] args) throws MinhaExcecao{
        String[] bolsa = {"", "", "", "", ""};
        boolean retorno = true;

        while (retorno) {
            try{
                System.out.println(
                    "\nEscolha sua acao"+
                    "\n 1 - ver bolsa"+
                    "\n 2 - remover item"+
                    "\n 3 - adicionar item"+
                    "\n 4 - sair");

                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        verBolsa(bolsa);
                        break;
                    case 2:
                        removerItem(bolsa);
                        break;
                    case 3:
                        adicionarItens(bolsa);
                        break;    
                    case 4:
                        retorno = false;
                        break;
                    default:
                        throw new MinhaExcecao("escolha uma opção valida");
                }
            }catch(MinhaExcecao e){
                System.out.println("\n" + e);
            }catch(InputMismatchException e){
                System.out.println("Error: Informe apenas numeros");
            }
        }
    }

    public static void verBolsa(String[] bolsa){
        System.out.println("INVENTARIO");
        for(int i = 0; i < 5; i++){
            System.out.println("[" + (i+1) + "] : " + bolsa[i]);
        }
    }

    public static void removerItem(String[] bolsa) throws MinhaExcecao{
        try{
            verBolsa(bolsa);
            System.out.println("Escolha o item a ser removido");
            int numItem = sc.nextInt();
            if(numItem > 5 || numItem < 1){
                throw new MinhaExcecao("esse slot nao existe");
            }else{
                if(bolsa[numItem-1] == ""){
                    throw new MinhaExcecao("Esse slot não possui itens");
                }else{
                    bolsa[numItem-1] = "";
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Informe apenas numeros");
        }
    }

    public static void adicionarItens(String[] bolsa) throws MinhaExcecao{
        try{
            verBolsa(bolsa);
            System.out.println("Escolha o slot para adicionar o item");
            
            int numItem = sc.nextInt();
            if(numItem > 5 || numItem < 1){
                throw new MinhaExcecao("esse slot nao existe");
            }else{
                if(bolsa[numItem-1] != ""){
                    throw new MinhaExcecao("esse slot já esta sendo utilizado");
                }else{
                    System.out.println("Qual item deseja adicionar?");
                    sc.nextLine();
                    String item = sc.nextLine();
                    bolsa[numItem-1] = item;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: Informe apenas numeros");
        }
    }
}
