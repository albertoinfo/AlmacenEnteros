import java.util.Scanner;

/**
 * Clase de prueba de la clase almacene
 * @author alberto
 *
 */
public class TestAlmacen1 {

	static public void main(String[] argv) {

		Almacen1 prueba = new Almacen1();
		Scanner sc = new Scanner(System.in);
		int opcion;

		mostrarMenu();
		opcion = sc.nextInt();
		while (opcion != 0) {
			procesarOpcion(opcion, prueba);
			mostrarMenu();
			opcion = sc.nextInt();
		}
		sc.close();

	}

	static void mostrarMenu() {
		System.out.println("--- MENÚ DE  CONTROL DEL ALMACÉN -----");
		System.out.println(" 1.- Mostrar contenido del Almacén");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 7.- Empaquetar");
		System.out.println(" 0.- Terminar");
		System.out.print(" Introduzca una opción:[1-6]:");
	}

	// Procesa la opción introducida operando sobre el objeto Almacen1
	static void procesarOpcion(int opcion, Almacen1 parAlmacen) {
		Scanner entrada = new Scanner(System.in);
		int valor;

		switch (opcion) {
		case 1:
			System.out.println("Almacen = " + parAlmacen);
			break;
		case 2:
			System.out.print("Valor a Introducir:");
			valor = entrada.nextInt();
			if (parAlmacen.ponValor(valor)) {
				System.out.println(" Valor introducido.");
			} else {
				System.out.println(" Error: Valor no introducido.");
			}
			break;
		case 3:
			System.out.print("Valor a buscar:");
			valor = entrada.nextInt();
			if (parAlmacen.estaValor(valor)) {
				System.out.println(" El valor está almacenado.");
			} else {
				System.out.println(" El valor No está almacenado.");
			}
			break;
		case 4:
			System.out.print("Valor a Eliminar:");
			valor = entrada.nextInt();
			if (parAlmacen.sacarValor(valor)) {
				System.out.println(" Valor Eliminado.");
			} else {
				System.out.println(" Error: Valor no Eliminado");
			}
			break;
		case 5:
			System.out.println(" Posiciones Ocupadas = " + parAlmacen.numPosicionesOcupadas());
			break;
		case 6:
			System.out.println(" Posiciones libres = " + parAlmacen.numPosicionesLibres());
			break;
		case 7:
			System.out.println("Empaquetando..."); parAlmacen.empaquetar();
			break;
		}

	}

}
