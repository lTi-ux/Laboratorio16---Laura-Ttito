import java.util.*;
public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mapa mapa = new Mapa();  
        mapa.generarEjercitos();       
        mapa.posicionarEjercitos();
        mapa.mostrarMapa();
        
        while (true) {
            System.out.println("\nEstado actual del mapa:");
            mapa.mostrarMapa();

            boolean ejercito1Vivo = false;
            boolean ejercito2Vivo = false;            
            for (Ejercito ejercito : mapa.ejercitos) {
                if (ejercito.getReino().getNombre().equals("Inglaterra") || ejercito.getReino().getNombre().equals("Francia")) {
                    if (!ejercito.getSoldados().isEmpty()) {
                        ejercito1Vivo = true;
                    }
                } else {
                    if (!ejercito.getSoldados().isEmpty()) {
                        ejercito2Vivo = true;
                    }
                }
            }
            if (!ejercito1Vivo || !ejercito2Vivo) {
                if (!ejercito1Vivo) {
                    System.out.println("¡El ejército de Inglaterra y Francia ha sido derrotado!");
                }
                if (!ejercito2Vivo) {
                    System.out.println("¡El ejército de los otros reinos ha sido derrotado!");
                }
                break; 
            }
            for (Ejercito ejercito : mapa.ejercitos) {
                System.out.println("\nTurno del ejército de " + ejercito.getReino().getNombre());
                System.out.print("Ingrese la fila (1-10) y columna (A-J) de un soldado a mover: ");
                int fila = scanner.nextInt() - 1;
                char columnaChar = scanner.next().charAt(0);
                int columna = columnaChar - 'A';

                System.out.print("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha): ");
                String direccion = scanner.next();
                
                mapa.moverSoldado(fila, columna, direccion, ejercito.getReino().getNombre());               
                mapa.mostrarMapa();
            }
        }
        scanner.close();
    }
}
