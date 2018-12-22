public class Bst {
    private Intervalo intervalo;
    private Bst left;
    private Bst right;

    Bst(){
        this.intervalo= null;
        this.left = null;
        this.right = null;
    }

    public Bst upd (Bst root, int posicao, int valorUP){
        if(root.intervalo == null){
            root.intervalo.setMin(valorUP);
            return root;
        }else if(root.intervalo.getLimiteI() == posicao && root.intervalo.getLimiteS() == posicao){
            root.intervalo.setMin(valorUP);
            return root;
        }else if( posicao <= (root.intervalo.getLimiteI() + root.intervalo.getLimiteS())/2 ){
            root.left = upd(root.left, posicao, valorUP);
            root.intervalo.setMin(min(root.left.intervalo.getMin(), root.right.intervalo.getMin()));
            return root;
        }else {
            root.right = upd(root.right, posicao, valorUP);
            root.intervalo.setMin(min(root.left.intervalo.getMin(), root.right.intervalo.getMin()));
            return root;
        }
    }

    public Bst generate (int[] array, int l, int r){
        Intervalo intervalo = new Intervalo(l,r);
        Bst nova = new Bst();
        if( r <= l ){
            nova.intervalo = intervalo;
            nova.intervalo.setMin(array[l]);
        }else{
            nova.intervalo = intervalo;
            int media = (l+r)/2;
            nova.left = generate(array,l,media);
            nova.right = generate(array,media +1,r);
            nova.intervalo.setMin( min(nova.left.intervalo.getMin(), nova.right.intervalo.getMin()) );
        }
        return nova;
    }
    public int min(int left,int right){
        if(left <= right){
            return left;
        }else{
            return right;
        }
    }
    public void prt (Bst root, int l, int r, int tamanho){
        if(root.intervalo == null){
            return ;
        }
        if( root.left != null && l <= (root.intervalo.getLimiteI() + root.intervalo.getLimiteS())/2) {
            prt(root.left, l,r,tamanho);
        }
        if(root.right != null && r >= ((root.intervalo.getLimiteS() + root.intervalo.getLimiteI())/2)+1 ){
            prt(root.right,l,r,tamanho);
        }
        if(root.intervalo.getLimiteI() == 0 && root.intervalo.getLimiteS() == tamanho -1){
            System.out.print(root.intervalo.getMin());
        }else{
            System.out.print(root.intervalo.getMin() + " ");
        }
    }
    public int rmq (Bst root, int l, int r){
        if(l > r || l > root.intervalo.getLimiteS() || r < root.intervalo.getLimiteI()){
            return Integer.MAX_VALUE;
        }else if (l == root.intervalo.getLimiteI() && r == root.intervalo.getLimiteS()){
            return root.intervalo.getMin();
        }else{
            int m = (root.intervalo.getLimiteI() + root.intervalo.getLimiteS())/2;
            return min(rmq(root.left,max(root.intervalo.getLimiteI(),l),min(r,m)),rmq(root.right,max(l,m+1),min(r,root.intervalo.getLimiteS())) );
        }
    }
    public int max(int left, int rigth){
        if(left >= rigth){
            return left;
        }else{
            return rigth;
        }
    }
}
