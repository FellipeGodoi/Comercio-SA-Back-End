package br.com.muralis.comercio.controller;

import br.com.muralis.comercio.entity.Client;
import br.com.muralis.comercio.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    //buscar
    @GetMapping
    public ResponseEntity<List<Client>> findClient(@RequestParam(required = false) String filter) {
        if (filter != null && !filter.isEmpty()) {
            List<Client> clients = clientService.findClients(filter);
            if (clients.isEmpty()) {
                throw new IllegalArgumentException("Nenhum Cliente com esses parametros encontrados.");
            }
            return ResponseEntity.ok(clients);
        }
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    //criar
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody @Valid Client client) {
        Client newClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(newClient);
    }

    //att
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        if (clientService.getClientById(id).isPresent()) {
            Optional<Client> updClient = clientService.updateClient(clientDetails, id );
            return updClient.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        throw new IllegalArgumentException(" Cliente não encontrados.");
    }


    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
