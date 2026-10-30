package view;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Renderizable;

public class DashboardView extends JFrame {

    private final JTextField campoBusqueda = new JTextField(18);

    private final JButton botonBuscar = new JButton("Buscar");
    private final JButton botonListar = new JButton("Mostrar todos");
    private final JButton botonOrdenar = new JButton("Ordenar por memoria");
    private final JButton botonInteractuar = new JButton("Interactuar por ID");
    private final JPanel panelWidgets = new JPanel(new GridLayout(0, 2, 10, 10));
    private final JLabel etiquetaEstado = new JLabel(" ");

    public DashboardView() {
        setTitle("Dashboard de widgets");
        setSize(950, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

            JLabel titulo = new JLabel(
            "Panel de control", SwingConstants.CENTER
        );

        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));

        JPanel controles = new JPanel(new FlowLayout());
        controles.add(new JLabel("ID o nombre:"));
        controles.add(campoBusqueda);
        controles.add(botonBuscar);
        controles.add(botonListar);
        controles.add(botonOrdenar);
        controles.add(botonInteractuar);

        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.add(titulo, BorderLayout.NORTH);
        encabezado.add(controles, BorderLayout.CENTER);

        // Contenedor de los widgets.
        panelWidgets.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JScrollPane scroll = new JScrollPane(panelWidgets);

        add(encabezado, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(etiquetaEstado, BorderLayout.SOUTH);
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
        panelWidgets.removeAll();

        for (Renderizable widget : widgets) {
            JPanel tarjeta = new JPanel(new BorderLayout());

            JLabel datos = new JLabel(
                "ID: " + widget.getId()
                + " | Memoria: " + widget.getMemoriaKB() + " KB"
            );

            tarjeta.add(datos, BorderLayout.NORTH);
            tarjeta.add(widget.obtenerVista(), BorderLayout.CENTER);

            panelWidgets.add(tarjeta);
        }

        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public String getTextoBusqueda() {
        return campoBusqueda.getText().trim();
    }

    public void mostrarEstado(String mensaje) {
        etiquetaEstado.setText(mensaje);
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public JButton getBotonListar() {
        return botonListar;
    }

    public JButton getBotonOrdenar() {
        return botonOrdenar;
    }

    public JButton getBotonInteractuar() {
        return botonInteractuar;
    }
}