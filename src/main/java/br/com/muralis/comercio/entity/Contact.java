package br.com.muralis.comercio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "Tipo não pode estar vazio")
    @Column(length = 50, nullable = false)
    public String tipo;

    @NotBlank(message = "Este valor não pode ser nulo")
    @Column(length = 100, nullable = false)
    public String valor;

    @Column
    public String observacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;

}
