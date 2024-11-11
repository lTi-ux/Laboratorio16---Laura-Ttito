import java.util.ArrayList;
import java.util.List;

public class Ejercito {
    private List<Soldado> soldados;
    private Reino reino;

    public Ejercito(Reino reino) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
    }

    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public Reino getReino() {
        return reino;
    }
}
