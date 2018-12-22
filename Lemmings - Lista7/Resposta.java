public class Resposta {
    private int tamanho;
    private String resposta;
    Resposta(int tamanho, String resposta){
        this.tamanho = tamanho;
        this.resposta = resposta;
    }
    public int getTamanho(){
        return this.tamanho;
    }
    public String getResposta(){
        return this.resposta;
    }
    public void setResposta (String novo){
        this.resposta = novo;
    }
    public void setTamanho(int novo){
        this.tamanho = novo;
    }
}