package org.example.innovationmotors.controller;

import jakarta.validation.Valid;
import org.example.innovationmotors.model.CarroModel;
import org.example.innovationmotors.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping
    public List<CarroModel> listar(){
        return carroService.listarVeiculos();
    }

    @PostMapping
    public CarroModel salvar(@RequestBody @Valid CarroModel carro){
        return carroService.cadastrar(carro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        carroService.excluir(id);
    }

    @GetMapping("/{id}")
    public CarroModel buscarPorId(@PathVariable Long id){
        return carroService.buscarPorId(id);
    }

    @GetMapping("/buscarPorMarca/{marca}")
    public List<CarroModel> buscarPorMarca(@RequestParam String marca){
        return carroService.buscarPorMarca(marca);
    }

    @GetMapping("/buscarPorModelo/{modelo}")
    public List<CarroModel> buscarPorModelo(@RequestParam String modelo){
        return carroService.buscaPorModelo(modelo);
    }

    @GetMapping("/buscarPorAno/{ano}")
    public List<CarroModel> buscarPorAno(@RequestParam Integer ano){
        return carroService.buscarPorAno(ano);
    }

    @GetMapping("buscarPorPreco/{preco}")
    public List<CarroModel> buscarPorPreco(@RequestParam Double preco){
        return carroService.buscarPorPreco(preco);
    }


}
