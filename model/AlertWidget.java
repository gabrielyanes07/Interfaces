public class AlertWidget extends WidgetBase implements Interactivo{
    private final String mensaje;
    private final String prioridad;
    private boolean leida = false;

    public AlertWidget(int id, String mensaje,
                       String prioridad, double memoriaKB) {

        super(id, "Alerta", memoriaKB);

        this.mensaje = mensaje;
        this.prioridad = prioridad;
    }

    @Override
    protected String obtenerTexto() {
        String estado = leida ? "Leída" : "Pendiente";

        return "[" + prioridad + "] " + mensaje
                + " — " + estado;
    }

    @Override
    public void interactuar() {
        leida = true;
        renderizar();
    }
}
