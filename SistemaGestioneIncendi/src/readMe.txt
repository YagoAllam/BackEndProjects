Models:

		class Sonda    --> Long id;
				           Double latitude;
				           Double longitude;
				           Double smokeLevel;
           
           

           
           
Class CentroControllo -->  Long id;






Azioni:
Sonda controlla il smokeLevel 
manda un segnale se è +5 allarme

allarma è controllata da una classe obsrvable (Canale di comunicazione)  -> solo invia il segnale in 
modo da poter personalizzare in futuro


