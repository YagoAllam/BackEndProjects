## PROCESSO LOGICO

# Goal--> aggregare i Processi che hanno un medesimo ordine di esecuzione delle attività per ottenere le #10 varianti# più frequenti.

- ragruppare i processi per id e ordinare le attività per data (attività con stesso id) --> .sort()
- creaere un DTO Variante --> due attributi: variante e istances
- Generare la lista dei varianti --> ciclo for()--> ogni gruppo
  while() --> Per ogni gruppo controlla se la variante di attività è già presente (aumenta le instances: quante volte compare l'attività) altrimenti ne crea una nuova

- prendere i 10 varianti + frequenti --> .subList()

# Goal--> stamparli in formato JSON sulla base di #una struttura che abbia senso#.

- un builder gSon
  (problema: formato di data OffsetDateTime; soluzione: un serializer per convertire OssetDateTime in String)
- Struttura che abbia senso --> serializer per visualizzare l'oggetto variante con array interno invece che {variante: { eventList: [] }}
- generare il JSON e stamparlo

## COSA NON HO FATTO / GESTITO

...

## COME HO VALUTATO LA CORRETTEZZA DELLA SOLUZIONE

...
