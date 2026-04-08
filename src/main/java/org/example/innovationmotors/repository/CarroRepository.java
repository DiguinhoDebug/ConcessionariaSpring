package org.example.innovationmotors.repository;

import org.example.innovationmotors.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository <CarroModel, Long> {
    List<CarroModel> findByMarcaContainingIgnoreCase(String marca);
    List<CarroModel> findByModeloContainingIgnoreCase(String modelo);
    List<CarroModel> findByAno(Integer ano);
    List<CarroModel> findByPreco(Double preco);
}
