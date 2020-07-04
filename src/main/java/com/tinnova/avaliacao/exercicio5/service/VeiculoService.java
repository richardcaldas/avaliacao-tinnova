package com.tinnova.avaliacao.exercicio5.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tinnova.avaliacao.exercicio5.model.Veiculo;
import com.tinnova.avaliacao.exercicio5.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(final int id){
        return veiculoRepository.findById(id).orElse(null);
    }

    public List<Veiculo> findByVeiculo(final String veiculo){
        return veiculoRepository.findByVeiculo(veiculo);
    }

    public Veiculo create(final Veiculo veiculo) throws Exception{
        if (!this.validaMarca(veiculo.getMarca())){
            throw new Exception("Marca inválida");
        }
        veiculo.setCreated(new Date());
        veiculo.setUpdated(new Date());
        return veiculoRepository.save(veiculo);
    }

    public void deleteById(final int id){
        veiculoRepository.deleteById(id);
    }

    public Veiculo update(final int id, final Veiculo veiculo) throws Exception{
        final Veiculo veiculoDatabase = this.findById(id);
        if (veiculoDatabase == null){
            throw new Exception("Veiculo Nao Encontrado");
        }

        if (!this.validaMarca(veiculo.getMarca())){
            throw new Exception("Marca inválida");
        }

        veiculoDatabase.setVeiculo(veiculo.getVeiculo());
        veiculoDatabase.setMarca(veiculo.getMarca());
        veiculoDatabase.setAno(veiculo.getAno());
        veiculoDatabase.setDescricao(veiculo.getDescricao());
        veiculoDatabase.setVendido(veiculo.isVendido());
        veiculoDatabase.setUpdated(new Date());
        
        return veiculoRepository.save(veiculoDatabase);


    }


    public Veiculo updateVendido(final int id, final Veiculo veiculo) throws Exception{
        final Veiculo veiculoDatabase = this.findById(id);
        
        veiculoDatabase.setVendido(veiculo.isVendido());
        veiculoDatabase.setUpdated(new Date());
        
        return veiculoRepository.save(veiculoDatabase);


    }


    private List<String> getMarcasValidas(){
        final List<String> marcasValidas = new ArrayList<>();
        marcasValidas.add("Volkswagen");
        marcasValidas.add("Ford");
        marcasValidas.add("Chevrolet");
        marcasValidas.add("Audi");
        marcasValidas.add("BMW");
        marcasValidas.add("Fiat");
        marcasValidas.add("Honda");
        marcasValidas.add("Renault");
        return marcasValidas;
    }

    private boolean validaMarca(final String marca){
        return this.getMarcasValidas().stream()
                                        .anyMatch(v -> v.equalsIgnoreCase(marca));

    }

}