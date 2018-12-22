public class Passiente {
    private int urgencia;
    private int idade;
    private int servico;
    private int ordem;
    Passiente(int urgencia, int idade, int servico, int ordem){
        this.urgencia = urgencia;
        this.idade = idade;
        this.servico = servico;
        this.ordem = ordem;
    }
    public int getUrgencia(){
        return this.urgencia;
    }
    public int getIdade() {
        return idade;
    }
    public int getOrdem() {
        return ordem;
    }
    public int getServico() {
        return servico;
    }
}
