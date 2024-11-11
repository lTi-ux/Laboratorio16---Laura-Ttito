
public class Soldado {
    private int id;
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private String actitud;
    private boolean vive;
    private Reino reino;
    
    public Soldado(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, Reino reino) {
        this.id = id;
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
        this.actitud = "Defensiva";
        this.vive = true;
        this.reino = reino;
    }
    public void aplicarBonus(String territorio) {
        if (reino.tieneBonus(territorio)) {
            this.vidaActual += 1; // Bonus de vida
        }
    }

    public void serAtacado(int dano) {
        this.vidaActual -= dano;
        if (this.vidaActual <= 0) {
            morir();
        }
    }

    public void morir() {
        this.vive = false;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Reino getReino() {
        return this.reino;
    }

    @Override
    public String toString() {
        return nombre + " | Vida: " + vidaActual;
    }
}
