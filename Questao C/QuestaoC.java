import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestaoC{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
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
            sc.close();
            System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
        }
    }

    public static void cadastroPessoa(){
        CadastroPessoa cadPessoa = new CadastroPessoa();

        System.out.println("Iniciado processo para cadastro de pessoa.");
        cadPessoa.setNome(nomePessoa());
        cadPessoa.setEmail(emailPessoa());
        cadPessoa.setDataNasc(nascPessoa());

        System.out.println(cadPessoa.getEmail());
    }

    public static String nomePessoa(){
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
            sc.close();
        }
        return nome;
    }

    public static String emailPessoa(){
        boolean emailSimb;
        String email = "";

        try{
            do{
                emailSimb = false;
                System.out.print("Informe email: ");
                email = sc.nextLine();
                if(!email.contains("@")){
                    emailSimb = true;
                    System.out.println("Por favor, insira um email valido.");
                }
            }while(emailSimb);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }

        return email;
    }

    public static String nascPessoa(){
        boolean dataSimb;
        String data = "";

        try{
            do{
                dataSimb = false;
                System.out.print("Informe data de nascimento dd/mm/aaaa: ");
                data = sc.nextLine();
                if(!data.matches("[0-3][0-9][/][0-1][1-2][/][0-9]{4}")){
                    dataSimb = true;
                    System.out.println("Por favor, insira uma data valida.");
                }
            }while(dataSimb);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }

        return data;
    }
}