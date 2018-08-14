package com.dev.controllor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.entity.Etudiant;
import com.dev.repository.EtudiantRepository;

@RestController
//@RequestMapping(value="/api",method=RequestMethod.GET)
public class EtudiantRestControllor {

	@Autowired
	private EtudiantRepository etudiantRepository;
	////////////////////////////////////////////////////
	
	@GetMapping("/etudiants")
	public List<Etudiant> AllEtudiants(){
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant chercherEtudiants(@PathVariable(name="id")Long id){
		return etudiantRepository.findOne(id);
	}
	
	@GetMapping("/etudiants/")
	public Page<Etudiant> pageEtudiants(@RequestParam(name="mot")String mot, @RequestParam("size" ) int size, @RequestParam( "page" )int page){
		return etudiantRepository.selectEtudiant(mot, new PageRequest(page, size));
	}
	
	@PostMapping("/etudiants")
	public Etudiant SaveEtudiants(@RequestBody Etudiant etd){
		return etudiantRepository.save(etd);
	}
	
	@PutMapping("/etudiants/{id}")
	public Etudiant UpdateEtudiants(@PathVariable(name="id")Long id ,@RequestBody Etudiant etd){
		etd.setIdEtudiant(id);
		return etudiantRepository.save(etd);
		
	}
	
	@DeleteMapping("/etudiants/{id}")
	public void DeleteEtudiants(@PathVariable(value="id")Long id){
		 etudiantRepository.delete(id);
	}
}
