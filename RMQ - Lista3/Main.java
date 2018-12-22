import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int numSensores = in.nextInt();
        int[] sensores = new int[numSensores];
        for( int i = 0; i < numSensores; i++){
            sensores[i] = in.nextInt();
        }
        Bst tree = new Bst();
        tree = tree.generate(sensores,0, sensores.length-1);
        while (in.hasNext()){
            String comando = in.next();
            if(comando.equals("UPD")){
                int posicao = in.nextInt();
                int novoValor = in.nextInt();
                tree = tree.upd(tree,posicao,novoValor);
            }else if(comando.equals("PRT")){
                int l = in.nextInt();
                int r = in.nextInt();
                tree.prt(tree,l,r,numSensores);
                System.out.println();
            }else if(comando.equals("RMQ")){
                int l = in.nextInt();
                int r = in.nextInt();
                System.out.println(tree.rmq(tree,l,r));
            }
        }
    }
}
// problema com o elemento 15 no final do teste 1.