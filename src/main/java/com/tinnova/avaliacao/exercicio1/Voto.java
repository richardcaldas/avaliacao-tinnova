package com.tinnova.avaliacao.exercicio1;

import lombok.Data;

@Data
public class Voto {

    private double votosValidos;
    private double votosBrancos;
    private double nulos;

    public Voto(double votosValidos, double votosBrancos, double nulos){
        this.nulos = nulos;
        this.votosBrancos = votosBrancos;
        this.votosValidos = votosValidos;
    }    

}