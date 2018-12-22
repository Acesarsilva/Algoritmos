public class Pilha {
    private int lenning;
    private Pilha next;
    Pilha(){
        this.lenning = -1;
        this.next = null;
    }
    public Pilha inserir(int novoLenning){
        Pilha novo = new Pilha();
        novo.lenning = novoLenning;
        novo.next = this;
        return novo;
    }
    public int remover(){
        Pilha aux = new Pilha();
        aux.lenning = this.lenning;
        this.lenning = this.next.lenning;
        this.next = this.next.next;
        return aux.lenning;
    }
}