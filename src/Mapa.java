import java.util.*;

public class Mapa {
    private String[][] tablero;
    private List<Ejercito> ejercitos;
    private String tipoTerritorio;
    
    public Mapa() {
        tablero = new String[10][10];  // Tablero de 10x10
        ejercitos = new ArrayList<>();
        Random rand = new Random();
        // Asignamos aleatoriamente un tipo de territorio
        String[] territorios = {"Bosque", "Campo Abierto", "Montaña", "Desierto", "Playa"};
        tipoTerritorio = territorios[rand.nextInt(territorios.length)];
    }

    public void generarEjercitos() {
        Random rand = new Random();
        String[] reinos = {"Inglaterra", "Francia", "Castilla-Aragón", "Moros", "Sacro Imperio Romano Germánico"};
        
        // Generar entre 1 y 10 ejércitos para cada reino
        for (String reinoNombre : reinos) {
            Reino reino = new Reino(reinoNombre);
            if (reinoNombre.equals("Inglaterra") || reinoNombre.equals("Sacro Imperio Romano Germánico")) {
                reino.agregarTerritorioBonificado("Bosque");
            } else if (reinoNombre.equals("Francia")) {
                reino.agregarTerritorioBonificado("Campo Abierto");
            } else if (reinoNombre.equals("Castilla-Aragón")) {
                reino.agregarTerritorioBonificado("Montaña");
            } else if (reinoNombre.equals("Moros")) {
                reino.agregarTerritorioBonificado("Desierto");
            }          
            // Crear entre 1 y 10 ejércitos
            for (int i = 0; i < rand.nextInt(10) + 1; i++) {
                Ejercito ejercito = new Ejercito(i + 1, reino);
                // Crear entre 1 y 10 soldados para el ejército
                for (int j = 0; j < rand.nextInt(10) + 1; j++) {
                    Soldado soldado = new Soldado(j + 1, "Soldado" + j, rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(5) + 1, reino);
                    soldado.aplicarBonus(tipoTerritorio);
                    ejercito.agregarSoldado(soldado);
                }
                ejercitos.add(ejercito);
            }
        }
    }
    public void posicionarEjercitos() {
        Random rand = new Random();
        for (Ejercito ejercito : ejercitos) {
            // Posicionar ejércitos en el tablero
            int fila, columna;
            do {
                fila = rand.nextInt(10);
                columna = rand.nextInt(10);
            } while (tablero[fila][columna] != null);  // Si la casilla ya está ocupada

            // Aquí se debería agregar la representación del ejército en el tablero
            tablero[fila][columna] = ejercito.getReino().getNombre();
        }
    }
    public void mostrarMapa() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] != null ? tablero[i][j] : "_");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
public class Mapa {

}
