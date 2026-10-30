package model;
public class QuoteWidget extends WidgetBase{
    private final String frase;

    public QuoteWidget(int id, String frase, double memoriaKB) {
        super(id, "Frase del día", memoriaKB);
        this.frase = frase;
}

    @Override
    protected String obtenerTexto() {
        return "\"" + frase ;
    }
}
