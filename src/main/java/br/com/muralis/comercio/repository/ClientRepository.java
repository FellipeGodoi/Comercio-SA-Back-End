package br.com.muralis.comercio.repository;

import br.com.muralis.comercio.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :search, '%')) OR c.cpf LIKE CONCAT('%', :search, '%')")
    List<Client> findClientByNameOrCPF(@Param("search") String search);

}
