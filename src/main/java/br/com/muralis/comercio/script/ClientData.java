package br.com.muralis.comercio.script;

import br.com.muralis.comercio.entity.Client;
import br.com.muralis.comercio.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ClientData implements CommandLineRunner {

    private final ClientRepository clientRepository;

    public ClientData(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (clientRepository.count() == 0) {
            List<Client> clients = List.of(
                    new Client(null, "Mário Silva", "12345678901", LocalDate.parse("1990-05-20"), "Rua Brasil 54", null),
                    new Client(null, "Ana Souza", "23456789012", LocalDate.parse("1985-08-22"), "Av Europa 25", null),
                    new Client(null, "Bruno Oliveira", "34567890123", LocalDate.parse("1992-01-30"), "Av Asia 22", null),
                    new Client(null, "Lucia Martins", "45678901234", LocalDate.parse("1987-12-10"), "Rua Italia 564", null),
                    new Client(null, "Fernando Costa", "56789012345", LocalDate.parse("1995-07-05"), "Av. América 88", null),
                    new Client(null, "Patricia Silva", "67890123456", LocalDate.parse("2000-03-25"), "Rua das Flores 15", null),
                    new Client(null, "Carlos Pereira", "78901234567", LocalDate.parse("1983-11-17"), "Av. Central 9", null),
                    new Client(null, "Mariana Rodrigues", "89012345678", LocalDate.parse("1998-04-08"), "Travessa da Paz 123", null),
                    new Client(null, "Thiago Gomes", "90123456789", LocalDate.parse("1993-06-20"), "Rua das Palmeiras 101", null),
                    new Client(null, "Juliana Oliveira", "01234567890", LocalDate.parse("1996-09-15"), "Alameda Azul 42", null)
            );

            clientRepository.saveAll(clients);
            System.out.println("10 clientes cadastrados no banco de dados.");
        } else {
            System.out.println("Clientes préviamente cadastrados no banco de dados.");
        }
    }
}