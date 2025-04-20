package Gerenciamento;

public enum SituacaoEscalacaoEnum {

    TITULAR(11), RESERVA(12);
    private final Integer qntdMax;

    private SituacaoEscalacaoEnum(Integer qntdMax) {
        this.qntdMax = qntdMax;
    }

    public Integer getQntdMax() {
        return this.qntdMax;
    }
}
