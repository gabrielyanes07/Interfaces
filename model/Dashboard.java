import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dashboard {

    private final List<Renderizable> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
        init();
    }

    private void init() {
        widgets.add(new WidgetClima(
            1, "Guatemala", 24, 120));

        widgets.add(new WidgetClima(
            2, "Antigua Guatemala", 20, 115));

        widgets.add(new TaskWidget(3, "Tareas de programación", 
        Arrays.asList("Crear interfaces", "Crear Dashboard"), 180));

        widgets.add(new TaskWidget(4, "Tareas de estudio", 
        Arrays.asList("Repasar Java", "Leer sobre MVC"),160));

        widgets.add(new AlertWidget(
            5, "Entrega del proyecto mañana", "Alta", 80
        ));

        widgets.add(new AlertWidget(
            6, "Hay una actualización disponible", "Media", 75
        ));

        widgets.add(new ClockWidget(7, 50));
        widgets.add(new ClockWidget(8, 50));

        widgets.add(new QuoteWidget(
            9, "Cada paso cuenta.", "Anónimo", 30
        ));

        widgets.add(new QuoteWidget(
            10, "Aprender requiere práctica.", "Anónimo", 35
        ));
    }

    public List<Renderizable> getWidgets() {
        return new ArrayList<>(widgets);
    }

    public void agregarWidget(Renderizable widget) {
        if (widget == null) {
            throw new IllegalArgumentException(
                "El widget no puede ser null."
            );
        }

        if (buscarPorId(widget.getId()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un widget con ese ID."
            );
        }

        widgets.add(widget);
    }

    public Renderizable buscarPorId(int id) {
        for (Renderizable widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }

        return null;
    }

    public List<Renderizable> buscarPorNombre(String nombre) {
        List<Renderizable> encontrados = new ArrayList<>();

        for (Renderizable widget : widgets) {
            if (widget.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(widget);
            }
        }

        return encontrados;
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }

    public boolean interactuarConWidget(int id) {
        Renderizable widget = buscarPorId(id);

        if (widget instanceof Interactivo) {
            ((Interactivo) widget).interactuar();
            return true;
        }

        return false;
    }
}
