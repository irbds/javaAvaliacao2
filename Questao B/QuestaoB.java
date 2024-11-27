/*Faça um programa em Java, usando tratamento de exceções, que receba o CPF
e o estado de uma pessoa e verifique se as informações estão de acordo. 
Faça o tratamento caso as informações não sejam coerentes. 
Obs: Para esse programa é necessário criar uma exceção própria. */

import java.util.Scanner;

public class QuestaoB {
	public static void main (String [] args) {
		Scanner scanner = new Scanner (System.in);

	    try{
            System.out.print("Digite o seu CPF: ");
            String cpf = scanner.nextLine();

            if (!cpf.matches("\\d{11}")) {
                throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos.");
            }

            System.out.print("Qual o seu Estado?  ");
            String estado = scanner.nextLine().toUpperCase();

            if (!isValidoEstado(estado)) {
                throw new IllegalArgumentException("Estado inválido! Forneça uma sigla válida.");
            }

            if (!isValidCpfEstado(cpf, estado)){
                throw new IllegalArgumentException("O digito do CPF não condiz com o estado indicado");
            }

                System.out.println("CPF e estado válidos!");
        }catch(IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static boolean isValidoEstado(String estado) {
        boolean valido = false;
        String [] validoEstados = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", 
            "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };
        for (String validoEstado : validoEstados) {
            if (validoEstado.equals(estado)) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public static boolean isValidCpfEstado(String cpf, String estado){
        int digitoCPF = Integer.parseInt(cpf.substring(8,9));
        boolean valido = false;
        String [] CPF1 = {"DF", "GO", "MT", "MS", "TO"};
        String [] CPF2 = {"AC", "AM", "AP", "PA", "RO", "RR"};
        String [] CPF3 = {"CE", "MA", "PI"};
        String [] CPF4 = {"AL", "PB", "PE", "RN"};
        String [] CPF5 = {"BA", "SE"};
        String [] CPF6 = {"MG"};
        String [] CPF7 = {"ES", "RJ"};
        String [] CPF8 = {"SP"};
        String [] CPF9 = {"PR", "SC"};
        String [] CPF0 = {"RS"};
        
        if(digitoCPF == 1){
            for (String validoEstado : CPF1)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 2){
            for (String validoEstado : CPF2)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 3){
            for (String validoEstado : CPF3)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 4){
            for (String validoEstado : CPF4)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 5){
            for (String validoEstado : CPF5)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 6){
            for (String validoEstado : CPF6)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 7){
            for (String validoEstado : CPF7)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 8){
            for (String validoEstado : CPF8)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 9){
            for (String validoEstado : CPF9)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        if(digitoCPF == 0){
            for (String validoEstado : CPF0)
                if (validoEstado.equals(estado)) {
                    valido = true;
                    break;
                }
        }
        return valido;
    }
}