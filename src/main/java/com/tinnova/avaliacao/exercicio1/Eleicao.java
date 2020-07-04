package com.tinnova.avaliacao.exercicio1;

import lombok.Data;

@Data
public class Eleicao {

    private Voto voto;
    private double totalEleitores;

    public Eleicao(){
        this.voto = new Voto(800,150,50);
        this.totalEleitores = 1000;
    }
    
    public double getPercentualVotosValidos(){
        return (this.voto.getVotosValidos() / this.totalEleitores) * 100;
    }

    public double getPercentualVotosBrancos(){
        return (this.voto.getVotosBrancos() / this.totalEleitores) * 100;
    }

    public double getPercentualVotosNulos(){
        return (this.voto.getNulos() / this.totalEleitores) * 100;
    }

    
}