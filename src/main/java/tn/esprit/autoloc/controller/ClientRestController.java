
package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Gestion des Clients", description = "API CRUD pour gérer les clients")
public class ClientRestController {

    private final IClientService clientService;

    public ClientRestController(IClientService clientService) {
        this.clientService = clientService;
    }


    @Operation(summary = "Récupérer tous les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients récupérée")
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.retrieveAllClients();
    }


    @Operation(summary = "Récupérer un client par son ID")
    @ApiResponse(responseCode = "200", description = "Client trouvé")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(
            @PathVariable Long id) {

        Client client = clientService.retrieveClient(id);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }


    @Operation(summary = "Ajouter un nouveau client")
    @ApiResponse(responseCode = "201", description = "Client créé")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    @PostMapping
    public ResponseEntity<Client> addClient(
            @RequestBody Client client) {

        client.setIdClient(null);
        Client created = clientService.addClient(client);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }


    @Operation(summary = "Modifier un client existant")
    @ApiResponse(responseCode = "200", description = "Client modifié")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @RequestBody Client client) {

        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }

        client.setIdClient(id);

        return ResponseEntity.ok(
                clientService.updateClient(client));
    }


    @Operation(summary = "Supprimer un client")
    @ApiResponse(responseCode = "204", description = "Client supprimé")
    @ApiResponse(responseCode = "404", description = "Client introuvable")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(
            @PathVariable Long id) {

        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }

        clientService.removeClient(id);

        return ResponseEntity.noContent().build();
    }
}
