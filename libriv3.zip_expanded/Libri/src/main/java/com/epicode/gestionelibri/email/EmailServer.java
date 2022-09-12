package com.epicode.gestionelibri.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailServer {

	private String serverPostaInUscita;
	private String serverPostaInEntrataUscita;
	private String user;
	private String password;
	private String nomeServer;
	
	public void inviaEmail( String to, String oggetto, String testo  ) {
		log.info("--- Inviata email con server " + nomeServer);
	}
}
