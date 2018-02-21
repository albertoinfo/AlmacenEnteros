import java.util.Arrays;

/*
 * Implementar un almacen de enteros mediante  dos zonas 
 * una ordenada y otra con posiciones libres
 */
public class Almacen2 {

	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;

	/**
	 * Constructores sin parámetros creo una tabla de 10 elementos
	 */
	public Almacen2() {
		this(10); // Llamo al constructor con parámetros
	}

	/** 
	 * Constructor donde se fija tamaño máximo del Almacén
	 * @param tamaño números de elementos a máximo 
	 */
	public Almacen2(int tamaño) {
		tvalores = new int[tamaño];
        valoresAlmacenados = 0; 
	}

	/**
	 *  Muestra una cadena con los valores ocupados de la tabla
	 */
	public String toString() {
		StringBuilder resu =new  StringBuilder("{");
		for (int i=0;i<valoresAlmacenados;i++){
			if ( i >0 ) resu.append(",");
			resu.append(tvalores[i]);
		}
		resu.append('}');
		return resu.toString();
	}

	/**
	 *  Devuelve el números de posiciones libres
	 * @return un entero con el número de posiciones libres
	 */
	public int numPosicionesLibres() {
		return tvalores.length - valoresAlmacenados;
	}

	/**
	 *  Devuelve el número de posiones ocupadas
	 * @return un entero con al número de posiciones ocupadas
	 */
	public int numPosicionesOcupadas() {
		return valoresAlmacenados;
	}

	/**
	 *  Devuelve verdadero o falso si está almacenado el valor en la tabla
	 * @param num - valor a buscar
	 * @return true o false
	 */
	public boolean estaValor(int num) {
	
		return ( Arrays.binarySearch(tvalores, 0, valoresAlmacenados, num) >= 0);

	}

	/**
	 * Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	 * Lo inserta en su sitio
	 * @param num - valor a inserta
	 * @return true o false
	 */
	
	public boolean ponValor (int num){
		boolean colocado = false;
		if ( !estaLleno()){
			int pos = Arrays.binarySearch(tvalores, 0, valoresAlmacenados, num);
			if (pos < 0){
				// No está me ha dicho la posición donde deberia estar 
				pos = pos*(-1)-1;
			}
			// Desplazo a la derecha para dejar hueco
			for ( int i= valoresAlmacenados; i > pos; i--){
				tvalores[i]=tvalores[i-1];
			}
			// Coloco
			tvalores[pos]= num;
			valoresAlmacenados++;
			colocado = true;
		}			
	return colocado;
	}

	/**
	 * Elimina el elemento de la tabla, si no esta devuelve false
	 * Mueve el resto para que no queden huecos
	 * @param num elemento a eliminar
	 * @return true o false
	 */
	
	public boolean sacarValor(int num) {
		boolean eliminado = false;
		int pos = Arrays.binarySearch(tvalores, 0, valoresAlmacenados, num);
		if ( pos >=0){
			// Desplazo a la izquierda para borrar
			for (int i=pos; i < valoresAlmacenados-1; i++){
				tvalores[i] = tvalores[i+1];
			}
			valoresAlmacenados--;
			eliminado = true;
		}
		
		return eliminado;
	}

	/**
	 * Indica si el almacén esta lleno
	 * @return true o false
	 */
	public boolean estaLleno() {
		return (valoresAlmacenados == tvalores.length);
	}
	
	/**
	 * Elimina los huecos intermedios
	 * En esta implementación es innecesario pues no se generan huecos
	 */
	public void empaquetar (){
		// Nunca hay huecos
	}
}