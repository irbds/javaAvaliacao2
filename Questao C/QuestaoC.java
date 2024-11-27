import java.util.Scanner;

public class QuestaoC{
    static Scanner sc = new Scanner(System.in);
    static CadastroPessoa cadPessoa = new CadastroPessoa();
    static CadastroCarro cadCarro = new CadastroCarro();

    public static void main(String[] args){
        try{
            cadastroPessoa();
            cadastroCarro();
            System.out.println("Carro modelo: " + cadCarro.getModelo() + "\nPlaca: " + cadCarro.getPlaca() + "\ncadastrado no nome de " + cadPessoa.getNome());
        }catch(Exception e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
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
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }
    }

    public static void cadastroCarro(){
        try{
            System.out.println("Iniciado processo para cadastro do carro.");
            cadCarro.setMarca(marcaCarro());
            cadCarro.setModelo(modeloCarro());
            cadCarro.setPlaca(placaCarro());
            System.out.println(cadCarro.getModelo() + " Cadastrado.");
        }catch(Exception e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());
            sc.close();
        }
    }

    public static String nomePessoa(){
        boolean nomeNum = false;
        String nome = "";

        while(!nomeNum){
        try{
                nomeNum = true;
                System.out.print("Informe nome: ");
                nome = sc.nextLine();
                if(!nome.matches("[A-z ]+")){
                    nomeNum = false;
                    throw new Exception("O nome não deve conter numeros ou ser vazio, insira novamente.");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return nome;
    }

    public static String emailPessoa(){
        boolean emailSimb = false;
        String email = "";

        while(!emailSimb){
            try{
                emailSimb = true;
                System.out.print("Informe email: ");
                email = sc.nextLine();
                if(!email.contains("@")){
                    emailSimb = false;
                    throw new Exception("Por favor, insira um email valido.");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return email;
    }

    public static String nascPessoa() throws Exception{
        boolean dataValid = false;
        String data = "";

        while(!dataValid){
            try{
                System.out.print("Informe data de nascimento dd/mm/aaaa: ");
                data = sc.nextLine();
                dataValid = cadPessoa.validaData(data);
                if(!dataValid){
                    dataValid = false;
                    throw new Exception("Por favor, insira uma data valida.");
                }
                if(cadPessoa.calculoIdade(data) < 18){
                    throw new Error("A pessoa a ser cadastrada é menor de idade");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }catch(Error e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return data;
    }

    public static String telPessoa(){
        boolean telSimb = false;
        String telefone = "";

        while(!telSimb){
            try{
                telSimb = true;
                System.out.print("Informe o telefone (11)91234-5678: ");
                telefone = sc.nextLine();
                if(!telefone.matches("[(][0-9]{2}[)][9][0-9]{4}[-][0-9]{4}")){
                    telSimb = false;
                    throw new Exception("Por favor, insira um numero valido conforme o indicado.");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return telefone;
    }

    public static String marcaCarro(){
        boolean marcaVerif = false;
        String marca = "";

        while(!marcaVerif){
            try{
                marcaVerif = true;
                System.out.print("Informe a marca: ");
                marca = sc.nextLine();
                if(marca == ""){
                    marcaVerif = false;
                    throw new Exception("Informe uma marca valida");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return marca;
    }

    public static String modeloCarro(){
        boolean modeloVerif = false;
        String modelo = "";

        while(!modeloVerif){
            try{
                modeloVerif = true;
                System.out.print("Informe o modelo: ");
                modelo = sc.nextLine();
                if(modelo == ""){
                    modeloVerif = false;
                    throw new Exception("Informe um modelo valida");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return modelo;
    }

    public static String placaCarro(){
        boolean marcaVerif = false;
        String marca = "";

        while(!marcaVerif){
            try{
                marcaVerif = true;
                System.out.print("Informe a placa: ");
                marca = sc.nextLine();
                if(!marca.matches("[A-Z]{3}[-][0-9]{4}") && !marca.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")){
                    marcaVerif = false;
                    throw new Exception("Informe uma placa valida");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return marca;
    }
}