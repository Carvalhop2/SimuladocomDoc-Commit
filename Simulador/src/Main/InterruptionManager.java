package Main;

import java.util.PriorityQueue;
/** 
* Classe responsável pelo gerenciamento de interrupções, incluindo a geração e o processamento de interrupções. 
* Fornece métodos para gerar e processar interrupções de diferentes tipos, 
* além de verificar o status atual da fila.
*/

public class InterruptionManager {

    /**
     * Método simples que adiciona uma fila de interrupções, nesse caso, uma interrupção do tipo Timer
     * 
     * @param Recebe uma fila de interrupções do tipo PriorityQueue<Interruption> nomeado de fila, onde a interrupção será adicionada.
     * 
     */
    public static void gerarInterrupcaoTimer(PriorityQueue<Interruption> fila) {
        Interruption timer = new Interruption(InterruptType.TIMER);
        fila.add(timer);
        System.out.println("Interrupção de Timer gerada! \n");
    }
 
    /**
     *Método que vai adicionar uma interrupção do tipo IO à fila de interrupções.
     *
     *@param fila A fila de interrupções do tipo PriorityQueue<Interruption>,  onde a interrupção será adicionada..
     * 
     */
    public static void gerarInterrupcaoIO(PriorityQueue<Interruption> fila) {
        Interruption io = new Interruption(InterruptType.IO);
        fila.add(io);
        System.out.println("Interrupção de Entrada/Saída gerada!\n");
    }

    /** * Método que adiciona uma interrupção do tipo Erro de Sistema (SYSTEM_ERROR) na fila de interrupções. 
     * 	* 
     * 	* @param fila a fila de interrupções do tipo PriorityQueue<Interruption>. contendo as interrupções. 
     * */  
    public static void gerarInterrupcaoErroSistema(PriorityQueue<Interruption> fila) {
        Interruption erro = new Interruption(InterruptType.SYSTEM_ERROR);
        fila.add(erro);
        System.out.println("Interrupção de Erro de Sistema gerada!\n");
    }

    /**
     * Método que processa todas as interrupções na fila de acordo com a prioridade, removendo-as em ordem de prioridade.
     * Imprime no console o status de cada interrupção processada.
     *
     * @param fila a fila de prioridade do tipo PriorityQueue<Interruption> contendo as interrupções.
     */
    public static void processarInterrupcoes(PriorityQueue<Interruption> fila) {
        if (fila.isEmpty()) {
            System.out.println("A fila de interrupções está vazia.");
            return;
        }

        System.out.println("\n\nIniciando processamento das interrupções:");
        while (!fila.isEmpty()) {
            Interruption interrupcao = fila.poll(); 
            System.out.println("Processando: " + formatarInterrupcao(interrupcao));
        }
    }
    /**
     * Método que verifica o status atual da fila de interrupções, exibindo todas as interrupções ordenadas por ordem de prioridade.
    *
    *@param fila a fila de interrupçoes do tipo PriorityQueue<Interruption>, que contém as interrupções.
    */
    public static void verificarStatusQueue(PriorityQueue<Interruption> fila) {
    	fila.stream().sorted().forEach(interrupcao -> System.out.println(formatarInterrupcao(interrupcao)));
    }
    
    /**
     * Método auxiliar para formatar uma interrupção como uma string, incluindo tipo e prioridade.
     *
     * @param interrupcao a interrupção a ser formatada.
     * @return uma string formatada contendo informações do tipo e prioridade da interrupção.
     */ 
    
    private static String formatarInterrupcao(Interruption interrupcao) {
        return String.format("Tipo: %-15s | Prioridade: %d",
                interrupcao.getTipo(), interrupcao.getPrioridade());
    }
    
}
