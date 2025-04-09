package br.com.muralis.comercio.service;

import br.com.muralis.comercio.entity.Client;
import br.com.muralis.comercio.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new IllegalArgumentException("Client não encontrado");
        }
        return client;
    }

    public List<Client> findClients(String search) {
        return clientRepository.findClientByNameOrCPF(search);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> updateClient(Client clientDetails, Long id) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client updClient = existingClient.get();
            updClient.setId(id);
            updClient.setNome(clientDetails.getNome());
            updClient.setCpf(clientDetails.getCpf());
            updClient.setDataNascimento(clientDetails.getDataNascimento());
            updClient.setEndereco(clientDetails.getEndereco());
            return Optional.of(clientRepository.save(updClient));
        }
        return Optional.empty();
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException(" Cliente não encontrados.");
        }
        clientRepository.deleteById(id);
    }



}
