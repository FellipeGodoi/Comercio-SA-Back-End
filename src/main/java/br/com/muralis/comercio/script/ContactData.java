package br.com.muralis.comercio.script;

import br.com.muralis.comercio.entity.Client;
import br.com.muralis.comercio.entity.Contact;
import br.com.muralis.comercio.repository.ClientRepository;
import br.com.muralis.comercio.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ContactData implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    public ContactData(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (contactRepository.count() == 0) {
            List<Client> clients = clientRepository.findAll();
            List<Contact> contacts = new ArrayList<>();

            for (Client client : clients) {
                Contact phoneContact = new Contact(
                        null,
                        "Telefone",
                        gerarTelefoneFicticio(),
                        "Número de telefone principal",
                        client
                );

                Contact emailContact = new Contact(
                        null,
                        "Email",
                        gerarEmailFicticio(client.getNome()),
                        "Email pessoal",
                        client
                );

                contacts.add(phoneContact);
                contacts.add(emailContact);
            }

            contactRepository.saveAll(contacts);
            System.out.println("Contatos adicionados aos clientes.");
        }
    }

    private String gerarTelefoneFicticio() {
        int num = new Random().nextInt(9000) + 1000;
        return "(11) 9" + num + "-" + (new Random().nextInt(9000) + 1000);
    }

    private String gerarEmailFicticio(String nomeCliente) {
        String nomeTratado = nomeCliente.toLowerCase().replaceAll(" ", ".");
        return nomeTratado + "@exemplo.com";
    }
}