package Gerenciamento;

public class Principal {

    public static void main(String[] args) {

        Time flasco = new Time("Riverplay", "flasco"); //Criando time

        flasco.contratarJogador("Leandro", 15); // Criando/contratando jogador
        flasco.contratarJogador("Gabriel", 18);
        flasco.contratarJogador("Michael", 24);

        flasco.escalarJogador("Leandro", SituacaoEscalacaoEnum.TITULAR); //Escalando jogador contratado
        flasco.escalarJogador("Michael", SituacaoEscalacaoEnum.RESERVA);
        flasco.escalarJogador("Michael", SituacaoEscalacaoEnum.RESERVA); // Testando erro de escalar o jogador 2 vezes


        flasco.removerJogadorEscalacao("Gabriel"); //Testando erro de remover escalação de um jogador não escalado

        flasco.obterEscalacao(); //Listando todos os jogadores já escalados
        flasco.obterJogadoresContratados(); //Listando todos os jogadores contratados
        flasco.obterNumEscalacao(flasco); //Exibir a quantidade de jogadores titulares e reserva no time.

        flasco.removerJogadorEscalacao("Michael"); //Removendo jogador
        flasco.obterNumEscalacao(flasco); //Atualizando exibição
    }
}
