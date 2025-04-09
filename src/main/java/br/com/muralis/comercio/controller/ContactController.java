package br.com.muralis.comercio.controller;

import br.com.muralis.comercio.entity.Contact;
import br.com.muralis.comercio.service.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getContact(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.findContact(id));
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact, @PathVariable Long clientId) {
        Contact newContact = contactService.createContact(contact, clientId);
        return ResponseEntity.status(201).body(newContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody @Valid Contact contact ) {
        Contact updatedContact = contactService.updateContact(contact, id);
         return ResponseEntity.status(201).body(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
