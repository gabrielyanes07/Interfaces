import javax.swing.JComponent;
import javax.swing.Timer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget extends WidgetBase{
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Timer temporizador;

    public ClockWidget(int id, double memoriaKB) {
        super(id, "Reloj", memoriaKB);
    }

    @Override
    protected String obtenerTexto() {
        return LocalTime.now().format(formato);
    }

    @Override
    public JComponent obtenerVista() {
        JComponent vista = super.obtenerVista();

        if (temporizador == null) {
            temporizador = new Timer(1000, e -> renderizar());

            vista.addHierarchyListener(e -> {
                if (vista.isShowing()) {
                    renderizar();
                    temporizador.start();
                } else {
                    temporizador.stop();
                }
            });

            if (vista.isShowing()) {
                temporizador.start();
            }
        }

        return vista;
    }
}
