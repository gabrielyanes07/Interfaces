public class QuoteWidget extends WidgetBase{
    private final String frase;
    private final String autor;

    public QuoteWidget(int id, String frase, String autor, double memoriaKB) {
        super(id, "Frase del día", memoriaKB);
        this.frase = frase;
        this.autor = autor;
    }

    @Override
    protected String obtenerTexto() {
        return "\"" + frase + "\" — " + autor;
    }
}
