package br.com.muralis.comercio.entity;

//import br.com.muralis.comercio.exception.annotation.UniqueValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome não pode ser vazio")
    @Column(length = 100 ,nullable = false)
    private String nome;

    @NotBlank(message = "cpf não pode ser vazio")
    @Column(length = 14, nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "data de nascimento é obrigatória")
    @Column(nullable = false, name = "data_Nascimento")
    private LocalDate dataNascimento;

    @Column
    private String endereco;

    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contatos;

}
