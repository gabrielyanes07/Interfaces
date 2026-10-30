public class WidgetClima extends WidgetBase implements Interactivo{
    private final String ciudad;
    private final double temperaturaCelsius;
    private boolean mostrarCelsius = true;

    public WidgetClima(int id, String ciudad, double temperaturaCelsius, double memoriaKB) {

        super(id, "Clima de " + ciudad, memoriaKB);

        this.ciudad = ciudad;
        this.temperaturaCelsius = temperaturaCelsius;
    }

    @Override
    protected String obtenerTexto() {
        double temperatura = temperaturaCelsius;
        String unidad = "°C";

        if (!mostrarCelsius) {
            temperatura = temperaturaCelsius * 9.0 / 5.0 + 32;
            unidad = "°F";
        }

        return String.format(
            "%s: %.1f %s", ciudad, temperatura, unidad
        );
    }

    @Override
    public void interactuar() {
        mostrarCelsius = !mostrarCelsius;
        renderizar();
    }
}
