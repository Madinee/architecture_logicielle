package com.ensim.MaaApp.ClientRest;

import org.springframework.web.client.RestTemplate;

import fr.ensim.interop.introrest.model.Equipe;

public class Client {
	
	RestTemplate restTemplate = new RestTemplate();

	
	public void postGarantieTest() {
		Garantie garantie = restTemplate.postForObject("http://127.0.0.1:9090/api/garantie?nom={nom}&montant={montant}&description={description}",
				null,
				Garantie.class,
				"TOTO");
		System.out.println("POST => " + garantie);
	}
	

	public static void main(String[] args) {

	}

}
