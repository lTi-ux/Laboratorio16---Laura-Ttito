
import java.util.List;
import java.util.ArrayList;

public class Ejercito {
    private int id;
    private List<Soldado> soldados;
    private Reino reino;

    public Ejercito(int id, Reino reino) {
        this.id = id;
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

