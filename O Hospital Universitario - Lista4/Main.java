import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numS = in.nextInt();
        int ordem = 0;
        Passiente[][] espera = new Passiente[numS][1000];
        int[] heap_sizes = new int[numS];
        String comand = in.next();
        while( !comand.equals("END")){
            if(comand.equals("CIN")){
                int idade = in.nextInt();
                int urgencia = in.nextInt();
                int servico = in.nextInt();
                Passiente passiente = new Passiente(urgencia,idade,servico,ordem);
                ordem++;
                if(heap_sizes[servico] == espera[servico].length -1){
                    espera[servico] = dobrarTamanho(espera[servico]);
                }
                espera[servico][heap_sizes[servico]] = passiente;
                heap_sizes[servico]++;
                espera[servico] = bubble_upMax(espera[servico], heap_sizes[servico] -1);
            }else if(comand.equals("NXT")){
                int servicoDel = in.nextInt();
                if( heap_sizes[servicoDel] > 0){
                    Passiente passienteDel = delete(espera[servicoDel],heap_sizes[servicoDel]);
                    heap_sizes[servicoDel]--;
                    System.out.println(passienteDel.getServico() + " " + passienteDel.getIdade() + " " + passienteDel.getUrgencia());
                }else{
                    System.out.println("-1 -1 -1");
                }
            }else if(comand.equals("STD")){
                Passiente passiente = new Passiente(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
                boolean vazio = true;
                for(int cont = 0; cont < numS; cont++){
                    if(heap_sizes[cont] != 0 && maiorPrioridade(passiente,espera[cont][0])){
                        passiente = espera[cont][0];
                        vazio = false;
                    }
                }
                if(!vazio){
                    passiente = delete(espera[passiente.getServico()],heap_sizes[passiente.getServico()]);
                    heap_sizes[passiente.getServico()]--;
                    System.out.println(passiente.getServico() + " " + passiente.getIdade() + " " + passiente.getUrgencia());
                }else{
                    System.out.println("-1 -1 -1");
                }
            }
            comand = in.next();
        }
    }
    public static Passiente[] dobrarTamanho(Passiente[] fila){
        Passiente[] aux = new Passiente[(fila.length *2) +1];
        for(int cont = 0; cont < fila.length; cont++){
            aux[cont] = fila[cont];
        }
        return aux;
    }
    public static Passiente[] bubble_upMax(Passiente[] array, int posicao){
        while( posicao > 0 && maiorPrioridade(array[posicao],array[(posicao -1)/2])){
            Passiente aux = array[(posicao -1)/2];
            array[(posicao -1)/2] = array[posicao];
            array[posicao] = aux;
            posicao = (posicao -1)/2;
        }
        return array;
    }
    public static boolean maiorPrioridade(Passiente um, Passiente dois){
        if(um.getUrgencia() > dois.getUrgencia()){
            return true;
        }else if(um.getUrgencia() == dois.getUrgencia() && um.getIdade() > dois.getIdade()){
            return true;
        }else if(um.getUrgencia() == dois.getUrgencia() && um.getIdade() == dois.getIdade() && um.getOrdem() < dois.getOrdem()){
            return true;
        }else{
            return false;
        }
    }
    public static Passiente delete(Passiente[] array, int heap_size){
        Passiente aux = array[0];
        array[0] = array[heap_size-1];
        array[heap_size-1] = aux;
        heapfy(array,0,heap_size-1);
        return array[heap_size-1];
    }
    public static void heapfy(Passiente[] array, int posicao, int heap_size){
        int l = 2*posicao +1;
        int r = 2*posicao + 2;
        int m = posicao;
        if(l < heap_size && maiorPrioridade(array[l],array[m])){
            m = l;
        }
        if(r < heap_size && maiorPrioridade(array[r],array[m])){
            m = r;
        }
        if (m != posicao){
            Passiente aux = array[posicao];
            array[posicao] = array[m];
            array[m] = aux;
            heapfy(array,m,heap_size);
        }
    }
}