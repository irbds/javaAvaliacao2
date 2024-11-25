import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestaoC{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int escolha;
        try{
            do{
                System.out.print("Iniciado processo de cadastro");
                System.out.print("\n 1 - cadastro de pessoa");
                System.out.print("\n 2 - cadastro de carro");
                System.out.print("\n 3 - Sair\n");
                System.out.print("Informe o item desejado: "); escolha = sc.nextInt();
                if(escolha < 1 || escolha > 3){
                    System.out.println("Por favor, escolha umas das opções validas do menu");
                }else{
                    switch (escolha) {
                        case 1:
                            cadastroPessoa();
                            break;
                        case 2:
                            System.out.println("você escolheu o 2");
                            break;
                        case 3:
                            System.out.println("você escolheu o 3");
                            break;
                    }
                }
            }while(escolha < 1 || escolha > 3);
        }catch(InputMismatchException e){
            System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
        }finally{
            sc.close();
        }
    }

    public static void cadastroPessoa(){
        CadastroPessoa cadPessoa = new CadastroPessoa();

        cadPessoa.setNome(nomePessoa());

        System.out.println(cadPessoa.getNome());
        //System.out.print("Informe email: ");

        //System.out.print("Informe data de nascimento: ");

        //System.out.print("Informe telefone para contato: ");
    }

    public static String nomePessoa(){
        Scanner sc = new Scanner(System.in);
        boolean nomeNum;
        String nome = "";
        try{
            do{
                nomeNum = false;
                System.out.print("Informe nome: ");
                nome = sc.nextLine();
                if(!nome.matches("[A-z ]+")){
                    nomeNum = true;
                    System.out.println("O nome não deve conter numeros, insira novamente.");
                }
            }while(nomeNum);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
        return nome;
    }

    public static String emailPessoa(){
        Scanner sc = new Scanner(System.in);
        boolean emailSimb;
        String email = "";

        

        return email;
    }
}