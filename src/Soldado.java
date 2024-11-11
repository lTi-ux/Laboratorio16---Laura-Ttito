public class Soldado {
    private int id;
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(int id, String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad) {
        this.id = id;
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
        this.velocidad = velocidad;
        this.actitud = "Defensiva";
        this.vive = true;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaVivo() {
        return vidaActual > 0;
    }

    @Override
    public String toString() {
        return nombre + " | Vida: " + vidaActual + " | Actitud: " + actitud;
    }
}
