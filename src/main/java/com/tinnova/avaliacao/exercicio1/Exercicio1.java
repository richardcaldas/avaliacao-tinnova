package com.tinnova.avaliacao.exercicio1;

/**
 * Exercicio1
 */
public class Exercicio1 {

    public static void main(String[] args) {
        
        final Eleicao eleicao = new Eleicao();

        System.out.println("Percentual Votos Validos: " + eleicao.getPercentualVotosValidos() + "%");
        System.out.println("Percentual Votos Brancos: " + eleicao.getPercentualVotosBrancos() + "%");
        System.out.println("Percentual Votos Nulos: " + eleicao.getPercentualVotosNulos() + "%");

    }
    
}



