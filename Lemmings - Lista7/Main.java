import java.util.Scanner;
public class Main {
    public static Resposta bAb(int[] lanningOut,int[]lanningIn,int[] lanningIdeal,int indexIn, int indexOut,Resposta otima
            , Resposta corrente, int numLennings,Pilha pilha,int tamMaxCor) {
        int lowerBound = indexIn - indexOut;
        if(lowerBound >= otima.getTamanho()){
            return otima;
        }else{
            if(indexOut == numLennings && ordemLex(otima.getResposta(),corrente.getResposta())){
                otima = corrente;
                otima.setTamanho(tamMaxCor);
            }else{
                if(indexIn < numLennings){
                    otima = bAb(lanningOut,lanningIn,lanningIdeal,indexIn+1,indexOut,otima,
                            new Resposta(corrente.getTamanho() + 1, corrente.getResposta() + "0"),
                            numLennings,pilha.inserir(lanningIn[indexIn]),maior(tamMaxCor,lowerBound +1));
                }
                if(indexIn - indexOut > 0){
                    int aux = pilha.remover();
                    if(aux == lanningIdeal[indexOut]){
                        lanningOut[indexOut] = aux;
                        otima = bAb(lanningOut,lanningIn,lanningIdeal,indexIn,indexOut+1,otima,
                                new Resposta(corrente.getTamanho() -1,corrente.getResposta() + "Y"),
                                numLennings,pilha,maior(tamMaxCor,lowerBound -1));
                    }
                    pilha = pilha.inserir(aux);
                }
                return otima;
            }
        }
        return otima;
    }
    public static boolean ordemLex(String otima, String corrente) {
        if (otima.equals("")) {
            return true;
        } else {
            for (int cont = 0; cont < corrente.length(); cont++) {
                if (otima.charAt(cont) < corrente.charAt(cont)) { //O < Y
                    return false;
                } else if (otima.charAt(cont) > corrente.charAt(cont)) {
                    return true;
                }
            }
            return true;
        }
    }

    public static int maior (int i, int j){
        if(i >= j){
            return i;
        }else{
            return j;
        }
    }
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        for(int numFases = in.nextInt(); numFases > 0; --numFases){
            int numLennings = in.nextInt();
            int [] lenningIn = new int [numLennings];
            int [] lenningIdeal = new int [numLennings];
            for(int cont = 0; cont < numLennings; ++cont){
                lenningIn[cont] = in.nextInt();
            }
            int[]lenningOut = new int [numLennings];
            for(int cont = 0; cont < numLennings; ++cont){
                lenningIdeal[cont] = in.nextInt();
            }
            Resposta inicio = new Resposta(Integer.MAX_VALUE,"");
            Resposta corrente = new Resposta(0,"");
            Resposta solve = bAb(lenningOut,lenningIn,lenningIdeal,0,0,inicio,corrente,numLennings,new Pilha(),0);
            System.out.println(solve.getResposta() + " " + solve.getTamanho());
        }
    }
}