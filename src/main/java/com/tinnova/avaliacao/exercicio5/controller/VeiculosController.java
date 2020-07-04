package com.tinnova.avaliacao.exercicio5.controller;

import java.util.List;

import com.tinnova.avaliacao.exercicio5.model.Veiculo;
import com.tinnova.avaliacao.exercicio5.service.LojaService;
import com.tinnova.avaliacao.exercicio5.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private LojaService lojaService;

    @GetMapping(value="")
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());        
    }

    @GetMapping(value="/find")
    public ResponseEntity<List<Veiculo>> findByTermo(@RequestParam(name = "termo" , required= true) String termo){ 
        return ResponseEntity.ok(veiculoService.findByVeiculo(termo));        
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Integer id){
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @PostMapping(value="")
    public ResponseEntity<?> create(@RequestBody Veiculo veiculo) {
        try {
            return ResponseEntity.ok(veiculoService.create(veiculo));    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Veiculo veiculo) {
        try {
            return ResponseEntity.ok(veiculoService.update(id, veiculo));    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> updateFieldVendido(@PathVariable int id, @RequestBody Veiculo veiculo) {

        try {
            return ResponseEntity.ok(veiculoService.updateVendido(id, veiculo));    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            veiculoService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Veiculo nao encontrado");
        }
    }


    @GetMapping(value = "/quantidade-nao-vendidos")
    public ResponseEntity<?> getQuantidadeNaoVendidos() {
        try {
            return ResponseEntity.ok(lojaService.getVeiculosNaoVendidos());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/veiculos-por-decada-fabricacao")
    public ResponseEntity<?> getVeiculosPorDecadaFabricacao() {
        try {
            return ResponseEntity.ok(lojaService.getVeiculosByDecadaFabricacao());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/veiculos-por-fabricante")
    public ResponseEntity<?> getQuantidadeVeiculosPorFabricante() {
        try {
            return ResponseEntity.ok(lojaService.getVeiculosByFabricante());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/registrados-ultima-semana")
    public ResponseEntity<?> getVeiculosRegistradosUltimaSemana() {
        try {
            return ResponseEntity.ok(lojaService.getVeiculosRegistradosNaUltimaSemana());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    
}