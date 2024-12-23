package Main;

/** * Classe que representa uma interrupção e 
 * implementa a interface Comparable para ordenação. 
 * A interface {@code Comparable} permitir comparação baseada na prioridade.
 * */


public class Interruption implements Comparable<Interruption>{
	
	/** O tipo de interrupção, contendo informações sobre sua prioridade. */
	private InterruptType tipo;

	/** Método Construtor que inicializa a interrupção com um tipo específico.
	*
	* @param tipo o tipo da interrupção (Timer, IO, System Error, etc.).
	*/
		public Interruption(InterruptType tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obtém o tipo da interrupção.
	 * @return o tipo da interrupção.
	 */
	public InterruptType getTipo() {
		return tipo;
	}
	/**
	* Metódo Construtor que obtém a prioridade da interrupção com base no seu tipo..
	* @return a prioridade da interrupção.
	*/
	public int getPrioridade() {
		return tipo.getPrioridade();
	}
	
	/**
	* Descrever o metodo
	* @param descrever um parâmetro inteiro.
	* @return descrever o retorno, que será sempre 0.
	*/
	@SuppressWarnings("unused")
	private int metodo(int a) {
		return 0;
	}
	/**
	* Compara esta interupção com outra para ordenação.
	* @param o é a outra interrupção a ser comparada.
	* @return retorna um valor negativo se esta interrupção tiver menor prioridade,
	*         zero se tiver a mesma prioridade, ou um valor positivo se tiver maior prioridade.
	*/	
	@Override
	public int compareTo(Interruption o) {
		return Integer.compare(tipo.getPrioridade(), o.getPrioridade());
	}

	/** * Retorna uma representação em string da interrupção. 
	* @return uma string que descreve a interrupção com seu tipo e prioridade. 
	*/	
	@Override
	public String toString() {
        return "Interruption{" +
                "tipo=" + tipo +
                ", prioridade=" + getPrioridade() +
                '}';
    }
}
