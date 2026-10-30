import javax.swing.*;
import java.awt.BorderLayout;

public abstract class WidgetBase implements Renderizable{
        private final int id;
    private final String nombre;
    private final double memoriaKB;

    private JPanel panel;
    private JLabel etiqueta;

    public WidgetBase(int id, String nombre, double memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getMemoriaKB() {
        return memoriaKB;
    }

    protected abstract String obtenerTexto();

    @Override
    public void renderizar() {
        if (etiqueta != null) {
            etiqueta.setText(obtenerTexto());
        }
    }

    @Override
    public JComponent obtenerVista() {
        if (panel == null) {
            panel = new JPanel(new BorderLayout(5, 5));
            panel.setBorder(
                BorderFactory.createTitledBorder(nombre)
            );

            etiqueta = new JLabel(obtenerTexto());
            panel.add(etiqueta, BorderLayout.CENTER);

            if (this instanceof Interactivo) {
                JButton boton = new JButton("Interactuar");

                boton.addActionListener(e -> {
                    ((Interactivo) this).interactuar();
                });

                panel.add(boton, BorderLayout.SOUTH);
            }
        }

        return panel;
    }
}
