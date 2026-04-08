package org.example.innovationmotors.service;

import org.example.innovationmotors.model.CarroModel;
import org.example.innovationmotors.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carrorepository;

    public CarroService(CarroRepository carrorepository){
        this.carrorepository = carrorepository;
    }

    public List<CarroModel> listarVeiculos(){
        return carrorepository.findAll();
    }

    public CarroModel cadastrar(CarroModel carro){
        carro.setMargemLucro(carro.getPreco() * 0.10);
        return carrorepository.save(carro);
    }

    public void excluir(Long id){
        carrorepository.deleteById(id);
    }

    public CarroModel buscarPorId(Long id){
        return carrorepository.findById(id).orElseThrow(() -> new RuntimeException("Carro não encontrado!"));
    }

    public List<CarroModel> buscarPorMarca(String marca){
        return carrorepository.findByMarcaContainingIgnoreCase(marca);
    }

    public List<CarroModel> buscaPorModelo(String modelo){
        return carrorepository.findByModeloContainingIgnoreCase(modelo);
    }

    public List<CarroModel> buscarPorAno(Integer ano){
        return carrorepository.findByAno(ano);
    }

    public List<CarroModel> buscarPorPreco(Double preco){
        return carrorepository.findByPreco(preco);
    }

    public CarroModel atualizarCarro(Long id, CarroModel carro){
        buscarPorId(id);
        carro.setId(id);
        return carrorepository.save(carro);
    }

}
