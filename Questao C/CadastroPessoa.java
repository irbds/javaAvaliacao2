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
}