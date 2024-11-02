package br.com.fiap.agroclimate.agroclimatemvc.model;

public enum Clima {

    TROPICAL("Tropical", "Quente e úmido durante o ano todo, com chuvas intensas"),
    SUBTROPICAL("Subtropical", "Temperaturas moderadamente altas, com verões quentes e invernos suaves"),
    TEMPERADO("Temperado", "Clima com quatro estações bem definidas, verões amenos a quentes e invernos frios."),
    EQUATORIAL("Semiárido", "Altas temperaturas e muita umidade durante o ano todo, com chuvas frequentes."),
    SECO("Seco", "Baixa umidade e precipitação escassa, com temperaturas que podem variar bastante entre dia e noite"),
    ARIDO("Árido", "Muito seco, com pouca ou nenhuma chuva, e temperaturas extremas.");

    private final String label;
    private final String descricao;

    Clima(String label, String descricao) {
        this.label = label;
        this.descricao = descricao;
    }

    public String getLabel() {
        return label;
    }

    public String getDescricao() {
        return descricao;
    }
}
