package Main;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Classe principal que simula a geração e o processamento de interrupções em um sistema.
 * Utiliza duas threads:
 * - Uma para gerar interrupções aleatórias.
 * - Outra para processar as interrupções na fila de prioridade.
 */
public class Main {
	
    public static void main(String[] args) {
        // Fila de prioridade para interrupções
        PriorityQueue<Interruption> filaDeInterrupcoes = new PriorityQueue<>();

        // Thread geradora de interrupções
        /**
         * Thread responsável por gerar interrupções aleatórias em intervalos regulares.
         * As interrupções são do tipo TIMER, IO ou SYSTEM_ERROR, geradas aleatoriamente, através do gerador de intervalos aleatorios com o Random.
         */
        Thread geradorDeInterrupcoes = new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                	//Define um intervalo aleatório entre 1 e 4 segundos para criar uma interrupção do tipo aleatório de 1 a 3.
                    int intervalo = 1000 + random.nextInt(4000);
                    Thread.sleep(intervalo);

                    // Gera aleatoriamente de 1 a 3 interrupções por vez
                    int numeroDeInterrupcoes = 1 + random.nextInt(3);
                    for (int i = 0; i < numeroDeInterrupcoes; i++) {
                        int tipoAleatorio = random.nextInt(3); // 0, 1 ou 2 que corresponde aos tipos de interrções.
                        switch (tipoAleatorio) {
                            case 0 -> InterruptionManager.gerarInterrupcaoTimer(filaDeInterrupcoes);
                            case 1 -> InterruptionManager.gerarInterrupcaoIO(filaDeInterrupcoes);
                            case 2 -> InterruptionManager.gerarInterrupcaoErroSistema(filaDeInterrupcoes);
                        }
                    }
                    Thread.sleep(4000); // Thead de 4 segundo de tempo, que é um intervalo entre a geração das interrupções. 
                    					
                } catch (InterruptedException e) {
                    System.out.println("Gerador de interrupções interrompido.");
                    break;
                }
            }
        });

        /**
        *  Thread reponsável por processar as interrupções presentes na fila de prioridade.
        * Exibe o estado atual da fila e processa cada interrupção em ordem de prioridade.
        */
        Thread processadorDeInterrupcoes = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Aguarda um tempo antes de processar as interrupções

                    // Limpa a tela utilizando múltiplas quebras de linha
                    
                    /**
                    * Exibe o estado atual da fila de interrupções.
                    */
                    System.out.println("Estado atual da fila de interrupções:");
                    InterruptionManager.verificarStatusQueue(filaDeInterrupcoes);
                    System.out.println("\n");
                    
                    /**
                    * Processa todas as interrupções na fila.                    
                    */
                    InterruptionManager.processarInterrupcoes(filaDeInterrupcoes);
                    System.out.println("\n");
                } catch (InterruptedException e) {
                    System.out.println("Processador de interrupções interrompido.");
                    break;
                }
            }
        });

        // Inicia as threads
        geradorDeInterrupcoes.start();
        processadorDeInterrupcoes.start();
    }

}
