package com.dev;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.entity.Etudiant;
import com.dev.entity.Formation;
import com.dev.repository.EtudiantRepository;
import com.dev.repository.FormationRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Formation fr = new Formation();
		fr.setNomFormation("REACT");
		fr.setDureeFormation(30);
		//formationRepository.save(new Formation(30,f,null));
		formationRepository.save(fr);
		etudiantRepository.save(new Etudiant("Amine","Naji",new Formation(1L,0,null,null)));
	    formationRepository.findAll().forEach(f->{
	    	System.out.print(f.getNomFormation());
	    	});
	}

//	@Override
//	public void run(String... arg0) throws Exception {
//		// TODO Auto-generated method stub
//		Stream.of("REACT","Angular","Vue").forEach(f->{
//			Formation fr = new Formation();
//			fr.setNomFormation(f);
//			fr.setDureeFormation(30);
//			//formationRepository.save(new Formation(30,f,null));
//			formationRepository.save(fr);
//		});
//		//////////////////////////////////////////
//		etudiantRepository.save(new Etudiant("Amine","Naji",new Formation(1L,0,null,null)));
//		//etudiantRepository.save(new Etudiant("Yassine","Mounir",new Formation(2L,0,null,null)));
//	    ///////////////////////////////////////////
//	    formationRepository.findAll().forEach(f->{System.out.println(f.getEtudiants());});
//	}
}
