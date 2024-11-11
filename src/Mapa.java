import java.util.*;

public class Mapa {
    private Soldado[][] tablero;
    private List<Ejercito> ejercitos;
    private String tipoTerritorio;

    public Mapa() {
        this.tablero = new Soldado[10][10];
        this.ejercitos = new ArrayList<>();
        this.tipoTerritorio = generarTerritorio();
    }

    private String generarTerritorio() {
        String[] territorios = {"Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa"};
        Random rand = new Random();
        return territorios[rand.nextInt(territorios.length)];
    }

    public void generarEjercitos() {
        Reino reino1 = new Reino("Inglaterra");
        Reino reino2 = new Reino("Francia");

        Ejercito ejercito1 = new Ejercito(reino1);
        Ejercito ejercito2 = new Ejercito(reino2);

        Random rand = new Random();
        int numEjercitos1 = rand.nextInt(10) + 1;
        int numEjercitos2 = rand.nextInt(10) + 1;

        // Generar soldados para los ejércitos
        for (int i = 0; i < numEjercitos1; i++) {
            int numSoldados = rand.nextInt(10) + 1;
            for (int j = 0; j < numSoldados; j++) {
                Soldado soldado = new Soldado(j + 1, "Soldado" + (j + 1), rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(3) + 1);
                ejercito1.agregarSoldado(soldado);
            }
        }

        for (int i = 0; i < numEjercitos2; i++) {
            int numSoldados = rand.nextInt(10) + 1;
            for (int j = 0; j < numSoldados; j++) {
                Soldado soldado = new Soldado(j + 1, "Soldado" + (j + 1), rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(3) + 1);
                ejercito2.agregarSoldado(soldado);
            }
        }

        // Añadir los ejércitos a la lista
        ejercitos.add(ejercito1);
        ejercitos.add(ejercito2);
    }

    public void posicionarEjercitos() {
        Random rand = new Random();
        for (Ejercito ejercito : ejercitos) {
            for (Soldado soldado : ejercito.getSoldados()) {
                int fila, columna;
                do {
                    fila = rand.nextInt(10);
                    columna = rand.nextInt(10);
                } while (tablero[fila][columna] != null);  // Verificamos que no haya un soldado en esa posición
                tablero[fila][columna] = soldado;
            }
        }
    }

    public void mostrarMapa() {
        System.out.println("Territorio: " + tipoTerritorio);
        System.out.print("    ");
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 10; j++) {
                Soldado soldado = tablero[i][j];
                if (soldado != null) {
                    System.out.print("|" + soldado.getNombre().charAt(0) + soldado.getVidaActual() + " ");
                } else {
                    System.out.print("|_ ");
                }
            }
            System.out.println("|");
        }
    }

    public void moverSoldado(int fila, int columna, String direccion, String reino) {
        Soldado soldado = tablero[fila][columna];
        if (soldado != null && soldado.getNombre().contains(reino)) {
            int nuevaFila = fila;
            int nuevaColumna = columna;

            switch (direccion.toLowerCase()) {
                case "arriba":
                    nuevaFila--;
                    break;
                case "abajo":
                    nuevaFila++;
                    break;
                case "izquierda":
                    nuevaColumna--;
                    break;
                case "derecha":
                    nuevaColumna++;
                    break;
                default:
                    System.out.println("Dirección no válida.");
                    return;
            }

            if (nuevaFila >= 0 && nuevaFila < 10 && nuevaColumna >= 0 && nuevaColumna < 10) {
                if (tablero[nuevaFila][nuevaColumna] == null) {
                    tablero[nuevaFila][nuevaColumna] = soldado;
                    tablero[fila][columna] = null;
                } else {
                    System.out.println("Ya hay un soldado en esa posición.");
                }
            } else {
                System.out.println("Movimiento fuera del tablero.");
            }
        } else {
            System.out.println("Soldado no encontrado o no pertenece al reino.");
        }
    }

    public List<Ejercito> getEjercitos() {
        return ejercitos;
    }
}
