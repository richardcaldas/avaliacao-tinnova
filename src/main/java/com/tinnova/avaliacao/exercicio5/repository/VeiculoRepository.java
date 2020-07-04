package com.tinnova.avaliacao.exercicio5.repository;

import java.util.List;

import com.tinnova.avaliacao.exercicio5.model.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{


    public List<Veiculo> findByVeiculo(final String veiculo);

}