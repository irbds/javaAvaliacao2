import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestaoC{
    static Scanner sc = new Scanner(System.in);
    static CadastroPessoa cadPessoa = new CadastroPessoa();

    public static void main(String[] args){
        try{
            cadastroPessoa();
        }catch(InputMismatchException e){
            sc.close();
            System.out.println("Ops... você digitou caracteres. Precisamos que digite apenas números.");
        }
    }

    public static void cadastroPessoa(){
        
        try{
            System.out.println("Iniciado processo para cadastro de pessoa.");
            cadPessoa.setNome(nomePessoa());
            cadPessoa.setEmail(emailPessoa());
            cadPessoa.setDataNasc(nascPessoa());
            cadPessoa.setTelefone(telPessoa());
            System.out.println(cadPessoa.getNome() + " Cadastrado(a).");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void cadastroCarro(){
        CadastroCarro cadCarro = new CadastroCarro();

        System.out.println("Iniciado processo para cadastro do carro.");
        cadCarro.setmarca(marcaCarro());
        cadCarro.setmodelo(modeloCarro());
        cadCarro.setplaca(placaCarro());
        System.out.println(cadCarro.getmodelo() + " Cadastrado.");
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

    public static String nascPessoa() throws Exception{
        boolean davaValid;
        String data = "";
        try{
            do{
                System.out.print("Informe data de nascimento dd/mm/aaaa: ");
                data = sc.nextLine();
                davaValid = cadPessoa.validaData(data);
                if(!davaValid){
                    System.out.println("Por favor, insira uma data valida.");
                }
            }while(!davaValid);
            if(cadPessoa.calculoIdade(data) < 18){
                throw new Exception("A pessoa a ser cadastrada é menor de idade");
            }
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return data;
    }

    public static String telPessoa(){
        boolean telSimb;
        String telefone = "";

        try{
            do{
                telSimb = false;
                System.out.print("Informe o telefone (11)91234-5678: ");
                telefone = sc.nextLine();
                if(!telefone.matches("[(][0-9]{2}[)][9][0-9]{4}[-][0-9]{4}")){
                    telSimb = true;
                    System.out.println("Por favor, insira um numero valido conforme o indicado.");
                }
            }while(telSimb);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }

        return telefone;
    }

    public static String marcaCarro(){
        boolean marcaVerif;
        String marca = "";

        try{
            do{
                marcaVerif = false;
                System.out.print("Informe a marca: ");
                marca = sc.nextLine();
                if(!marca.matches("[A-z]")){
                    marcaVerif = true;
                    System.out.println("Informe uma marca valida");
                }
            }while(marcaVerif);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }
        return marca;
    }

    public static String modeloCarro(){
        boolean modeloVerif;
        String modelo = "";

        try{
            do{
                modeloVerif = false;
                System.out.print("Informe o modelo: ");
                modelo = sc.nextLine();
                if(!modelo.matches("[A-z]")){
                    modeloVerif = true;
                    System.out.println("Informe um modelo valida");
                }
            }while(modeloVerif);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }
        return modelo;
    }

    public static String placaCarro(){
        boolean marcaVerif;
        String marca = "";

        try{
            do{
                marcaVerif = false;
                System.out.print("Informe a placa: ");
                marca = sc.nextLine();
                if(!marca.matches("[A-Z]{3}[-][0-9]{4}") || !marca.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")){
                    marcaVerif = true;
                    System.out.println("Informe uma placa valida");
                }
            }while(marcaVerif);
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }
        return marca;
    }
}