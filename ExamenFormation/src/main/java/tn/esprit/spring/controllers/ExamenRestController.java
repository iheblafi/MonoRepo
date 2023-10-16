package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;
import tn.esprit.spring.interfaces.IExamenService;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/examen")
public class ExamenRestController {
	@Autowired
	IExamenService examenService;
	@PostMapping("/add-formateur")
	public void addFormateur(@RequestBody Formateur formateur) {
		examenService.ajouterFormateur(formateur);
	}
	@PostMapping("/add-apprenant")
	public void addApprenant(@RequestBody Apprenant apprenant) {
		examenService.ajouterApprenant(apprenant);
	}
	@PostMapping("/ajouterEtAffecterFormationAFormateur/{id-Formateur}")
	public void addApprenant(@RequestBody Formation formation,
							 @PathVariable("id-Formateur") Integer idFormateur) {
		examenService.ajouterEtAffecterFormationAFormateur(formation,idFormateur);
	}
	@PostMapping("/affecterApprenantFormation/{idApprenant}/{idFormation}")
	public void affecterApprenantFormation(@PathVariable("idApprenant") Integer idApprenant, @PathVariable("idFormation") Integer idFormation) {
		examenService.affecterApprenantFormation(idApprenant,idFormation);
	}
	@GetMapping("/getFormateurRemunerationByDate/{idFormateur}/{dateDebut}/{dateFin}")
	public Integer getFormateurRemunerationByDate(
			@PathVariable("idFormateur") Integer idFormateur,
			@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDebut,
			@PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFin
	){
	 	return  examenService.getFormateurRemunerationByDate(idFormateur,dateDebut,dateFin);
	}
	@GetMapping("/getRevenuByFormation/{idFormation}")
	public Integer getRevenuByFormation(@PathVariable("idFormation") Integer idFormation) {
	return 	examenService.getRevenuByFormation(idFormation);
	}
}


