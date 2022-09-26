
Tecnici e Clienti sono già stati inseriti

Form  = dto   edit get 

	N rapportino ____________________
	
	Data         ____________________
	
	Tecnico      ____________________V    value=id   text=nome e cognome
	
	Cliente      ____________________V    value=id   text=nome e cognome  [salva ]
	
	
	
	--------------- Tabella righe -------------------------------------- [+]  ---- (refresh)
	
	descrizione       UM       quantita    costo   [edit] [delete]
	
	
	
	Form 
		
		Descrizione    ____________________
		
		UM             ____________________V
		
		Quantità       ____________________
		
		Costo          _____________________      [SALVA] post-> RigheRapportino
		
		
		
		rapportino_id , descrizione ,      UM ,      quantita   , costo
		
		-------     -------   -----   ----    ------  
	
	     -------     -------   -----   ----    ------  
		
		[1] [2]
		
Caso due
	mando contemporaneamente rapportino e righe
	
	
	numero, data, cliente_id, tecnico_id 
	
		-> descrizione ,      UM ,      quantita   , costo 
		-> descrizione ,      UM ,      quantita   , costo 
		-> descrizione ,      UM ,      quantita   , costo 
		-> descrizione ,      UM ,      quantita   , costo 
	
	
	
	
	
	Tabella rapportini
	
	descrizione numero    cliente tecnico data  [inserisci] chiama form sopra.
												  passare l'id del rapportino da caricare		
	-------     -------   -----   ----    ------  [edit] [cancella]

	-------     -------   -----   ----    ------  
	
	-------     -------   -----   ----    ------  	
	
	
	[1] [2] [3]
	
			
		
		