public class Lista {
    private Arquivo arquivo;
    private Lista tail = null;
    private Lista next;
    Lista(){
        this.arquivo = null;
        this.next = null;
    }
    public void inserir(Arquivo arquivo){
        if(this.next == null){
            this.arquivo = arquivo;
            this.next = new Lista();
            tail = this;
        }else{
            Lista novo = new Lista();
            novo.arquivo = arquivo;
            tail.next = novo;
            tail = novo;
        }
    }
    public int busca(String nomeBusca, int cont){
        if( this.next != this.tail && !this.arquivo.getNome().equals(nomeBusca) ){
            return this.next.busca(nomeBusca,cont +1);
        }else{
            return cont;
        }
    }
}