import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CadastroPessoa {
    private String nome;
    private String email;
    private String dataNasc;
    private String telefone;

    public void setNome(String nome){ this.nome = nome; }

    public void setEmail(String email){ this.email = email; }

    public void setDataNasc(String dataNasc){ this.dataNasc = dataNasc; }

    public void setTelefone(String telefone){ this.telefone = telefone; }

    public String getNome(){ return this.nome; }

    public String getEmail(){ return this.email; }

    public String getDataNasc(){ return this.dataNasc; }

    public String getTelefone(){ return this.telefone; }

    //validação segue exemplo de https://www.guj.com.br/t/resolvido-validacao-de-data/339866/3
    public boolean validaData(String data){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        }catch (ParseException ex) {
            return false;
        }
    }
    
    public int calculoIdade(String data){
        try{
            int dia = Integer.parseInt(data.substring(0,2));
            int mes = Integer.parseInt(data.substring(3,5));
            int ano = Integer.parseInt(data.substring(6,10));
    
            Calendar cHoje= Calendar.getInstance();
            int idade = cHoje.get(Calendar.YEAR) - ano;
    
            if(cHoje.get(Calendar.MONTH) >= mes && cHoje.get(Calendar.DAY_OF_MONTH) > dia) idade += 1;
    
            return idade;
        }catch(Error e){
            System.out.println("Algo aconteceu, não foi possivel prosseguir com o cadastro");
            System.out.println(e.getMessage());

            return 0;
        }
    }
}