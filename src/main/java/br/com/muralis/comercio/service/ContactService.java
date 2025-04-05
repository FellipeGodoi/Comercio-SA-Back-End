package br.com.muralis.comercio.service;

import br.com.muralis.comercio.entity.Client;
import br.com.muralis.comercio.entity.Contact;
import br.com.muralis.comercio.repository.ClientRepository;
import br.com.muralis.comercio.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;

    //consulta

    public Optional<Contact> findContact(Long id) {
        return contactRepository.findById(id);
    }

    //create
    public Contact createContact(Contact contact, Long idCliente) {
        Client client = clientRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        contact.setClient(client);
        return contactRepository.save(contact);
    }

    //updt
    public Contact updateContact(Contact newContact, Long id) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setTipo(newContact.getTipo());
                    contact.setValor(newContact.getValor());
                    contact.setObservacao(newContact.getObservacao());
                    return contactRepository.save(contact);
                })
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    //delete
    public void deleteContact(Long id) {
        if (findContact(id).isPresent()) {
            contactRepository.deleteById(id);
        }
        throw new RuntimeException("Contanto não encontrado");
    }
}
