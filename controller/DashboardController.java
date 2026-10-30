package controller;
import java.util.ArrayList;
import java.util.List;
import view.DashboardView;
import model.Dashboard;
import model.Renderizable;
public class DashboardController {

    private final Dashboard modelo;
    private final DashboardView vista;

    public DashboardController(Dashboard modelo,
                               DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        configurarEventos();
    }

    private void configurarEventos() {
        vista.getBotonListar().addActionListener(e -> {
            mostrarTodos();
        });

        vista.getBotonBuscar().addActionListener(e -> {
            buscar();
        });

        vista.getBotonOrdenar().addActionListener(e -> {
            modelo.ordenarPorMemoria();
            vista.mostrarWidgets(modelo.getWidgets());
            vista.mostrarEstado(
                "Widgets ordenados de menor a mayor memoria."
            );
        });

        vista.getBotonInteractuar().addActionListener(e -> {
            interactuar();
        });
    }

    public void iniciar() {
        mostrarTodos();
        vista.setVisible(true);
    }

    private void mostrarTodos() {
        List<Renderizable> widgets = modelo.getWidgets();

        vista.mostrarWidgets(widgets);
        vista.mostrarEstado(
            "Widgets registrados: " + widgets.size()
        );
    }

    private void buscar() {
        String texto = vista.getTextoBusqueda();

        if (texto.isEmpty()) {
            mostrarTodos();
            return;
        }

        List<Renderizable> resultados;

        try {
            int id = Integer.parseInt(texto);
            Renderizable widget = modelo.buscarPorId(id);

            resultados = new ArrayList<>();

            if (widget != null) {
                resultados.add(widget);
            }
        } catch (NumberFormatException e) {
            resultados = modelo.buscarPorNombre(texto);
        }

        vista.mostrarWidgets(resultados);
        vista.mostrarEstado(
            "Resultados encontrados: " + resultados.size()
        );
    }

    private void interactuar() {
        int id;

        try {
            id = Integer.parseInt(vista.getTextoBusqueda());
        } catch (NumberFormatException e) {
            vista.mostrarEstado(
                "Escribe un ID numérico para interactuar."
            );
            return;
        }

        if (modelo.buscarPorId(id) == null) {
            vista.mostrarEstado(
                "No existe un widget con ese ID."
            );
            return;
        }

        boolean realizado = modelo.interactuarConWidget(id);

        if (realizado) {
            vista.mostrarEstado(
                "Interacción realizada con el widget " + id + "."
            );
        } else {
            vista.mostrarEstado(
                "Este widget es informativo y no permite interacción."
            );
        }
    }
}
