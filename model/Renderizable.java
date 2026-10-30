import javax.swing.JComponent;

public interface Renderizable {
    
        int getId();

    String getNombre();

    double getMemoriaKB();


    void renderizar();

    JComponent obtenerVista();

    @Override
    default int compareTo(Renderizable otro) {
        return Double.compare(
            this.getMemoriaKB(),
            otro.getMemoriaKB()
        );
    }
}
