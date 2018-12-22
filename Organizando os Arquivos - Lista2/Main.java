import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int numArquivos = in.nextInt();
        Arquivo[] pasta = new Arquivo[numArquivos];
        for(int i = 0; i < numArquivos; i++){
            String nomeArquivo = in.next();
            int idArquivo = in.nextInt();
            pasta[i] = new Arquivo(nomeArquivo,idArquivo);
        }
        // fim 1 entrada
        // iniciando gavetas
        int numGavetas = in.nextInt();
        Lista[] gavetas = new Lista[numGavetas];
        for(int i = 0; i < numGavetas; i++){
            gavetas[i] = new Lista();
        }
        // terminando gavetas
        // iniciando hash
        int numArquivosNovos = in.nextInt();
        int [] numArquivosGavetas = new int [numGavetas];
        for(int i = 0; i < numArquivosNovos; i++){
            int idBusca = in.nextInt();
            int posicao = buscaBinaria(pasta, idBusca);
            if(posicao != -1){
                int somaAsk = somaAskII(pasta[posicao].getNome(),0,0);
                int hash = somaAsk % numGavetas; // hash
                numArquivosGavetas[hash]++;
                gavetas[hash].inserir(pasta[posicao]);
            }
        }
        //finalizando hash
        //imprimindo num. arquivos em cada gaveta
        for(int i = 0; i < numGavetas; i++){
            System.out.println(i + ": " + numArquivosGavetas[i]);
        }
        //fim imprimir
        //inicio Busca
        int numArquivosBusca = in.nextInt();
        for(int i = 0; i < numArquivosBusca; i++){
            String nomeArquivoBusca = in.next();
            int somaAskBusca = somaAskII(nomeArquivoBusca,0,0);
            int posicaoGaveta = gavetas[somaAskBusca % numGavetas].busca(nomeArquivoBusca, 0);
            System.out.println(i + ": " + (posicaoGaveta +1) );
        }
        //fim busca
        //fim codigo
    }
    private static int buscaBinaria(Arquivo[] array, int idBusca){
        int l = 0;
        int r = array.length -1;
        while( l <= r ){
            int m = (l+r)/2;
            if(idBusca == array[m].getId()){
                return m;
            }else if (idBusca < array[m].getId()){
                r = m -1;
            }else{
                l = m +1;
            }
        }
        return -1;
    }
    private static int somaAskII(String nome, int cont, int somaAsk){
        if(cont < nome.length()){
            somaAsk += (cont + 1)*nome.charAt(cont);
            cont++;
            return somaAskII(nome,cont,somaAsk);
        }else{
            return somaAsk;
        }
    }
}
