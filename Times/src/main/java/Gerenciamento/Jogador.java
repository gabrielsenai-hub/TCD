package Gerenciamento;

public class Jogador {

    private String nome;
    private Integer numeroCamisa;
    private SituacaoEscalacaoEnum SituacaoEscalacaoEnum;

    public Jogador(String nome, int numeroCamisa) {
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        this.SituacaoEscalacaoEnum = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(Integer numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public SituacaoEscalacaoEnum getSituacaoEscalacaoEnum() {
        return SituacaoEscalacaoEnum;
    }

    public void setSituacaoEscalacaoEnum(SituacaoEscalacaoEnum situacaoEscalacaoEnum) {
        SituacaoEscalacaoEnum = situacaoEscalacaoEnum;
    }

    @Override
    public String toString() {
        return "Jogador: \n" +
                "\nNome: " + nome +
                "\nNúmero da camisa: " + numeroCamisa +
                "\nSituação escalação: " + getSituacaoEscalacaoEnum();

    }
}
