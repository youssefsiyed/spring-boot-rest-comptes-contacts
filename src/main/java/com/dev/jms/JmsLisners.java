package com.dev.jms;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.dev.entity.Etudiant;
import com.dev.repository.EtudiantRepository;

@Component
public class JmsLisners{

	@Autowired
	private EtudiantRepository etudiantRepository;
	////////////////////////////////////////////////////
	
	@JmsListener(destination="scolarite.topic")
	public void Receive( Message message ) throws Exception{
		if( message instanceof TextMessage){
			String contenu=((TextMessage) message).getText();
			System.out.println("****************");
			System.out.println("le message est :"+contenu);
			System.out.println("****************");
             Etudiant etd = new Etudiant();
             etd.setNomEtudiant(contenu);
             etudiantRepository.save(etd);
		}
	}
}
