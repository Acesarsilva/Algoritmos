public class Arquivo {
    private String nome;
    private int id;
    Arquivo(String nome,int id){
        this.nome = nome;
        this.id = id;
    }
    public String getNome(){
        return this.nome;
    }
    public int getId() {
        return this.id;
    }
}