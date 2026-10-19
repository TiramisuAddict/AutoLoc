
package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@Tag(name = "Gestion des Vehicules", description = "API CRUD pour gérer les véhicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    public VehiculeRestController(
            IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }


    @Operation(summary = "Récupérer tous les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée")
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }


    @Operation(summary = "Récupérer un véhicule par son ID")
    @ApiResponse(responseCode = "200", description = "Véhicule trouvé")
    @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(
            @PathVariable Long id) {

        Vehicule vehicule =
                vehiculeService.retrieveVehicule(id);

        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicule);
    }


    @Operation(summary = "Ajouter un nouveau véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé")
    @ApiResponse(responseCode = "400", description = "Données invalides")
    @PostMapping
    public ResponseEntity<Vehicule> addVehicule(
            @RequestBody Vehicule vehicule) {

        vehicule.setIdVehicule(null);

        Vehicule created =
                vehiculeService.addVehicule(vehicule);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }


    @Operation(summary = "Modifier un véhicule existant")
    @ApiResponse(responseCode = "200", description = "Véhicule modifié")
    @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {

        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }

        vehicule.setIdVehicule(id);

        return ResponseEntity.ok(
                vehiculeService.updateVehicule(vehicule));
    }


    @Operation(summary = "Supprimer un véhicule")
    @ApiResponse(responseCode = "204", description = "Véhicule supprimé")
    @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(
            @PathVariable Long id) {

        if (vehiculeService.retrieveVehicule(id) == null) {
            return ResponseEntity.notFound().build();
        }

        vehiculeService.removeVehicule(id);

        return ResponseEntity.noContent().build();
    }
}
