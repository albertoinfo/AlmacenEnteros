import java.util.Arrays;

/**
 * Implementar un almacen de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 * @author alberto lópez
 *
 */
public class Almacen1 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;

	/**
	 * Constructor sin parámetros creo una tabla de 10 elementos
	 */
	public Almacen1() {
		this(10); // Llamo al constructor con parámetros
	}

	
	/**
	 * Constructor crear la tabla de enteros con el tamaño indicado
	 * @param tamaño de la tabal
	 */
	public Almacen1(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}

	
	/**
	 * Pone todas las posiciones a LIBRES
	 */
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	
	/**
	 * Muestra una cadena con los valores de la tabla 
	 */
	public String toString() {
		return Arrays.toString(tvalores);
	}

	
	/**
	 * Devuelve el número de posiciones libres
	 * @return un entero de posiciones libres
	 */
	public int numPosicionesLibres() {
		return tvalores.length - valoresAlmacenados;
	}

	
	/**
	 * Devuelve el número de posiciones ocupadas
	 * @return un entero de posiciones ocupadas
	 */
	public int numPosicionesOcupadas() {
		return valoresAlmacenados;
	}

	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	
	/**
	 * Indica si el valor se encuentra en la tabla
	 * @param num a buscar
	 * @return true si se encuentra o false si no está
	 */
	public boolean estaValor(int num) {
		boolean esta = false;
		
		for (int i = 0; i < tvalores.length; i++) {
			if (tvalores[i] == num) {
				esta = true;
				break;
			}
		}
		return esta;
	}

	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	/**
	 * Introduce un valor en ta tabla
	 * @param num - valor a introducir
	 * @return devuelve true si puede introducir o false si no
	 */
	public boolean ponValor (int num){
		boolean colocado = false;
		for (int i = 0; i < tvalores.length; i++) {
			  if ( tvalores[i] == LIBRE){
				  tvalores[i] = num;
				  valoresAlmacenados++;
			      colocado = true;
				  break;
			  }
		}			
	return colocado;
	}

	// Elimina el elemento de la tabla, si no esta devuelve false
	/**
	 * Elimina el elemento de la tabla
	 * @param num - valor a eliminar
	 * @return devuelve true si puede eliminarlo o false si no lo encuentra
	 */
	public boolean sacarValor(int num) {
		boolean eliminado = false;
		for (int i = 0; i < tvalores.length; i++) {
			if (tvalores[i] == num) {
				tvalores[i] = LIBRE;
				valoresAlmacenados--;
				eliminado = true;
				break;
			}
		}
		return eliminado;
	}

	// Indica si el almacén esta lleno
	/**
	 * Comprueba si la tabla esta llena
	 * @return true o false
	 */
	public boolean estaLleno() {
		return (valoresAlmacenados == tvalores.length);
	}
	
	// Elimina los huecos intermedios
	/**
	 * Empaquete la tabla eliminando los huecos intermedios
	 */
	public void empaquetar (){
		int izda = 0;
		int dcha = tvalores.length -1;
		while ( izda < dcha){
			// Si hay un hueco a la izquierda muevo el valor de la derecha
			if ( (tvalores [izda] == LIBRE) && (tvalores[dcha] != LIBRE)){
				tvalores[izda] = tvalores[dcha];
				tvalores[dcha] = LIBRE;
				izda++;
				dcha--;
			}
			if ( tvalores [izda]!= LIBRE){
				izda++;
			}
			if ( tvalores [dcha] == LIBRE){
				dcha--;
			}
		}
	}
}