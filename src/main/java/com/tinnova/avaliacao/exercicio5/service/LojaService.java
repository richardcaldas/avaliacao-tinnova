package com.tinnova.avaliacao.exercicio5.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.tinnova.avaliacao.exercicio5.model.Veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private VeiculoService veiculoService;

    public Integer getVeiculosNaoVendidos(){
        final List<Veiculo> listVeiculos = veiculoService.findAll();
        return listVeiculos.stream()
                            .filter(v -> !v.isVendido())
                            .collect(Collectors.toList())
                            .size();

    }

    public Map<Integer, Long> getVeiculosByDecadaFabricacao(){
        final List<Veiculo> listVeiculos = veiculoService.findAll();

        return listVeiculos.stream()
                            .collect(Collectors.groupingBy(Veiculo::getDecada, Collectors.counting()));


    }

    public Map<String, Long> getVeiculosByFabricante(){
        final List<Veiculo> listVeiculos = veiculoService.findAll();

        return listVeiculos.stream()
                            .collect(Collectors.groupingBy(Veiculo::getMarca, Collectors.counting()));


    }

    public List<Veiculo> getVeiculosRegistradosNaUltimaSemana(){
        final List<Veiculo> listVeiculos = veiculoService.findAll();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyww", new Locale("en","US"));
        final Integer semanaAnoAtual = Integer.valueOf(dateFormat.format(new Date()));
        return listVeiculos.stream()
                    .filter(v -> v.getSemanaDoAno() >= semanaAnoAtual -1)
                    .collect(Collectors.toList());
    }
    
}