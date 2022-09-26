Abstract Factory

si usa per ottenere una serie di factory.


Esempio di utilizzo.

UN tema di un interfaccia grafica.


UNico tema

Factory che restituisce un componente.


	crea(tipo)
		
		se tipo == button  return new button
		se tipo == inputbox  return new inputbox
		se tipo == link return new link





	tema 1 (colore blu con scritte bianche)
		
		Factory tema 1
			crea(tipo)
			
				se tipo == button  return new BluAndWhitebutton
				se tipo == inputbox  return new  BluAndWhiteinputbox
				se tipo == link return new  BluAndWhitelink
		

		
		tema 1 (colore rosso con scritte gialle)
		
		Factory tema 1
			crea(tipo)
			
				se tipo == button  return new RedAndYellowebutton
				se tipo == inputbox  return new  RedAndYellowinputbox
				se tipo == link return new  RedAndYellowlink
				
				
				
Abstract factory che gestisce i temi

	crea(typo)
		se tipo == tema1 return new FactoryTema1 				
		se tipo == tema2 return new FactoryTema2 				