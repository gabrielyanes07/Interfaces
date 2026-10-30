package model;
import java.util.ArrayList;
import java.util.List;

public class TaskWidget extends WidgetBase implements Interactivo{
    private final List<String> tareas;
    private final boolean[] completadas;

    public TaskWidget(int id, String nombre, List<String> tareas, double memoriaKB){
        super(id, nombre, memoriaKB);
        this.tareas = new ArrayList<>(tareas);
        this.completadas = new boolean[tareas.size()];
    }

    @Override
    protected String obtenerTexto() {
        if (tareas.isEmpty()) {
            return "No hay tareas.";
        }

        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < tareas.size(); i++) {
            if (i > 0) {
                texto.append(" | ");
            }

            texto.append(completadas[i] ? "[X] " : "[ ] ");
            texto.append(tareas.get(i));
        }

        return texto.toString();
    }

    @Override
    public void interactuar() {
        for (int i = 0; i < completadas.length; i++) {
            if (!completadas[i]) {
                completadas[i] = true;
                break;
            }
        }

        renderizar();
    }
}
