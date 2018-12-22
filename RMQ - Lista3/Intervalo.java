public class Intervalo {
    private int min;
    private int limiteS;
    private int limiteI;
    Intervalo(int limiteI, int limiteS){
        this.limiteI = limiteI;
        this.limiteS = limiteS;
        this.min = Integer.MAX_VALUE;
    }
    public int getMin(){
        return this.min;
    }
    public int getLimiteS(){
        return this.limiteS;
    }
    public int getLimiteI(){
        return this.limiteI;
    }
    public void setMin(int newValor){
        this.min = newValor;
    }
}
