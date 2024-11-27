import java.util.Scanner;

public class QuestaoA {
    public static void main(String[] args) {
        boolean validEmail = false;
        Scanner sc = new Scanner(System.in);

        while(!validEmail){
            try{
                System.out.print("Informe o seu endereço de email academico: ");
                String email = sc.nextLine();
                if(email.contains("@fatec.sp.gov.br")){
                    validEmail = true;
                    System.out.println("Email valido, bem vindo " + email);
                }else{
                    throw new Exception("Por favor informe um email valido");
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }    
}