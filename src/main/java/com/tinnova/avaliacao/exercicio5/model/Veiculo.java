package com.tinnova.avaliacao.exercicio5.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;

    @Column(name="veiculo")
    private String veiculo;

    @Column(name="marca")
    private String marca;

    @Column(name="ano")
    private int ano;

    @Column(name="descricao")
    private String descricao;

    @Column(name="vendido")
    private boolean vendido;

    @Column(name="created", nullable = false)
    private Date created;

    @Column(name="updated", nullable = false)
    private Date updated;
    
    public Integer getDecada(){
        if (this.getAno() < 2000){
            return this.getAno()/10 * 10;
        }else{
            return this.getAno() / 10 * 10;
        }
    }

    public int getSemanaDoAno(){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyww", new Locale("en","US"));
        return Integer.valueOf(dateFormat.format(this.getCreated()));
    }

    
    
}