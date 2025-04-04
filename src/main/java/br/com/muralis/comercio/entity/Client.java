package br.com.muralis.comercio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100 ,nullable = false)
    private String nome;
    @Column(length = 14, nullable = false)
    private String cpf;
    @Column(nullable = false, name = "data_Nascimento")
    private LocalDate dataNascimento;
    @Column
    private String endereco;



}
