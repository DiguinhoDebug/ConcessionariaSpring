package org.example.innovationmotors.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Getter
@Setter
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o campo modelo não pode estar vazio!")
    private String modelo;

    @NotBlank(message = "O campo marca não pode estar vazio!")
    private String marca;

    @NotNull(message = "Informe o ano do veículo")
    @Max(value = 2026, message = "O ano tem que ser antes de 2026!")
    @Min(value = 1900, message = "O ano tem que ser depois de 1900!")
    private Integer ano;

    @NotNull(message = "O campo preço não pode estar vazio!")
    @Positive(message = "O preço tem que ser positivo/maior que zero!")
    private Double preco;

    @NotNull(message = "Precisa especificar se o veículo está disponível!!")
    private Boolean disponivel;

    private Double margemLucro;

    public CarroModel(){}

}
