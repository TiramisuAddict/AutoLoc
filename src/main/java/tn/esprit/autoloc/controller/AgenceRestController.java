
package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@Tag(name = "Gestion des Agences", description = "API CRUD pour gérer les agences")
public class AgenceRestController {

    private final IAgenceService agenceService;

    public AgenceRestController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @Operation(summary = "Récupérer toutes les agences")
    @ApiResponse(responseCode = "200",
            description = "Liste des agences récupérée")
    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }


    @Operation(summary = "Récupérer une agence par son ID")
    @ApiResponse(responseCode = "200",
            description = "Agence trouvée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(
            @PathVariable Long id) {

        Agence agence = agenceService.retrieveAgence(id);

        if (agence == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(agence);
    }


    @Operation(summary = "Ajouter une nouvelle agence")
    @ApiResponse(responseCode = "201",
            description = "Agence créée")
    @PostMapping
    public ResponseEntity<Agence> addAgence(
            @RequestBody Agence agence) {

        agence.setIdAgence(null);
        Agence created = agenceService.addAgence(agence);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }


    @Operation(summary = "Modifier une agence existante")
    @ApiResponse(responseCode = "200",
            description = "Agence modifiée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(
            @PathVariable Long id,
            @RequestBody Agence agence) {

        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }

        agence.setIdAgence(id);
        return ResponseEntity.ok(
                agenceService.updateAgence(agence));
    }


    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204",
            description = "Agence supprimée")
    @ApiResponse(responseCode = "404",
            description = "Agence introuvable")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(
            @PathVariable Long id) {

        if (agenceService.retrieveAgence(id) == null) {
            return ResponseEntity.notFound().build();
        }

        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
