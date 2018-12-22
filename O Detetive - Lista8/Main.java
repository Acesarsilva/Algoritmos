import java.util.Scanner;

public class Main {
    public static int[][] knapSack(int pesoMax,int[]valor,int[]peso,int numItens){
        int[][]valoresMax = new int[numItens+1][pesoMax+1];
        for(int cont = 1; cont <= numItens; ++cont){
            for(int cont2 = 1; cont2 <= pesoMax; ++cont2){
                if(peso[cont-1] <= cont2 && valor[cont-1] + valoresMax[cont-1][cont2 - peso[cont -1]] > valoresMax[cont-1][cont2]){
                    valoresMax[cont][cont2] = valor[cont-1] + valoresMax[cont-1][cont2 - peso[cont-1]];

                }else{
                    valoresMax[cont][cont2] = valoresMax[cont-1][cont2];
                }
            }
        }
        return valoresMax;
    }
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int numItens = in.nextInt();
        int pesoMax = in.nextInt();
        int[]valor = new int[numItens];
        int[]peso = new int[numItens];
        for(int cont = 0; cont < numItens; ++cont){
            valor[cont] = in.nextInt();
            peso[cont] = in.nextInt();
        }
        int[][] valoresMax = knapSack(pesoMax,valor,peso, numItens);
        System.out.println(valoresMax[numItens][pesoMax]);
        int contItem = numItens;
        int contPeso = pesoMax;
        String caminho = "";
        while(contItem > 0){
            if(valoresMax[contItem][contPeso] != valoresMax[contItem-1][contPeso]) {
                contPeso -= peso[contItem - 1];
                caminho = " " + (contItem-1) + caminho;
            }
            --contItem;
        }
        if(caminho.charAt(0) == ' '){
            caminho = caminho.substring(1,caminho.length());
        }
        System.out.print(caminho);
    }
}