package Gerenciamento;

import java.util.ArrayList;

public class Time {

    private String nomeTime;
    private String nomeTecnico;
    static int jogadoresReserva = 0;
    static int jogadoresEscalados = 0;
    private ArrayList<Jogador> listaDeJogadores = new ArrayList<>();
    private ArrayList<Jogador> listaDeJogadoresEscalados = new ArrayList<>();


    public Time(String nomeTime, String nomeTecnico) {
        this.nomeTime = nomeTime;
        this.nomeTecnico = nomeTecnico;
    }


    public void contratarJogador(String nomeJogador, Integer numeroCamisa) {

        Jogador jogador = new Jogador(nomeJogador, numeroCamisa);
        listaDeJogadores.add(jogador);
    }

    public Boolean escalarJogador(String nomeJogador, SituacaoEscalacaoEnum situacaoEscalacaoEnum) {
        if (limiteAtingido(situacaoEscalacaoEnum))
            return false;
        if (verificarExistente(nomeJogador) == null) {
            System.out.println("O jogador não existe.");
            return false;
        }
        for (Jogador jogadores : listaDeJogadores) {
            if (nomeJogador.equalsIgnoreCase(jogadores.getNome())) {
                if (isEscalado(jogadores))
                    return false;

                jogadores.setSituacaoEscalacaoEnum(situacaoEscalacaoEnum);
                listaDeJogadoresEscalados.add(jogadores);

                if (situacaoEscalacaoEnum == SituacaoEscalacaoEnum.TITULAR)
                    jogadoresEscalados++;
                if (situacaoEscalacaoEnum == SituacaoEscalacaoEnum.RESERVA)
                    jogadoresReserva++;

                listaDeJogadores.remove(jogadores);

                return true;
            }

        }
        return false;
    }

    private boolean isEscalado(Jogador jogador) {
        return jogador.getSituacaoEscalacaoEnum() != null;
    }

    private boolean limiteAtingido(SituacaoEscalacaoEnum situacaoEscalacaoEnum) {
        if (situacaoEscalacaoEnum == SituacaoEscalacaoEnum.TITULAR && jogadoresEscalados == 12)
            return true;
        if (situacaoEscalacaoEnum == SituacaoEscalacaoEnum.RESERVA && jogadoresReserva == 12)
            return true;

        return false;
    }

    private Jogador verificarExistente(String nomeJogador) {

        for (Jogador jogadores : listaDeJogadores) {
            if (jogadores.getNome().equalsIgnoreCase(nomeJogador))
                return jogadores;
        }
        for (Jogador escalado : listaDeJogadoresEscalados) {
            if (escalado.getNome().equalsIgnoreCase(nomeJogador))
                return escalado;
        }
        return null;
    }

    private Integer calcularQtddEscalacao(SituacaoEscalacaoEnum situacaoEscalacaoEnum) {
        Integer qtdd = 0;

        for (Jogador jogadores : listaDeJogadoresEscalados) {
            if (situacaoEscalacaoEnum.equals(jogadores.getSituacaoEscalacaoEnum())) {
                qtdd++;
            }
        }
        return qtdd;
    }

    public void removerJogadorEscalacao(String nomeJogador) {
        if (verificarExistente(nomeJogador) == null) {
            System.out.println("O jogador não existe.");
        } else {
            for (Jogador jogadorN : listaDeJogadores) {
                if (nomeJogador.equalsIgnoreCase(jogadorN.getNome()))
                    System.out.println("O jogador não está escalado.");
                break;
            }
            for (Jogador jogador : listaDeJogadoresEscalados) {
                if (nomeJogador.equalsIgnoreCase(jogador.getNome())) {
                    listaDeJogadoresEscalados.remove(jogador);
                    if (jogador.getSituacaoEscalacaoEnum() == SituacaoEscalacaoEnum.RESERVA)
                        jogadoresReserva--;
                    if (jogador.getSituacaoEscalacaoEnum() == SituacaoEscalacaoEnum.RESERVA)
                        jogadoresEscalados--;

                    jogador.setSituacaoEscalacaoEnum(null);
                    listaDeJogadores.add(jogador);
                    break;
                }
            }
        }
    }

    public void obterEscalacao() {

        for (Jogador exibir : listaDeJogadoresEscalados) {
            System.out.println(exibir);
        }
    }

    public void obterJogadoresContratados() {

        for (Jogador exibir : listaDeJogadores) {
            System.out.println(exibir);
        }
    }


    public void obterNumEscalacao(Time time) {

        System.out.println("\nNumero de jogadores titulares: " + time.calcularQtddEscalacao(SituacaoEscalacaoEnum.TITULAR) + "\nNumero de jogadores reserva: " + time.calcularQtddEscalacao(SituacaoEscalacaoEnum.RESERVA) + "\nNumero de jogadores contratados: " + listaDeJogadores.size());
    }


    public String getnomeTime() {
        return nomeTime;
    }

    public void setnomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

}
