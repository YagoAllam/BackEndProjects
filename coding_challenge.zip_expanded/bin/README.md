## Descrizione del problema
Un cliente ci chiede di elaborare una semplice statistica partendo da una estrazione dati effettuata nel suo backend.  
L'estrazione dati e' relativa ad un classico processo di eProcurement (ordine, fattura, bolla, etc).  
Un processo è rappresentato da un ProcessId, una serie di attività (create purchase request, request approved, pay invoice) ciascuna con una data di esecuzione.  
Le attività non seguono un ordine fisso, il che significa che ogni processo è una combinazione delle stesse attività, che possono quindi ripetersi in sequenze potenzialmente sempre diverse.  
L'estrazione dati è rappresentata dal file ProcessLog.csv.

Un processo di eProcurement, a parità di ID, potrebbe quindi essere composto dalle attività a, b, c, d, b , a, f, un altro dalle attività a, d, f.

## Obiettivo

* L'obiettivo è aggregare i processi che hanno un medesimo ordine di esecuzione delle attività per ottenere le 10 varianti più frequenti.
* Le 10 varianti più frequenti vanno stampate (System.out) in formato JSON sulla base di una struttura che abbia senso.
* Ci interessa che il codice sia semplice, pulito, di facile comprensione, ben organizzato. Ci aspettiamo l'impiego di strutture dati a supporto, ma anche un set minimo di DTO / Java Bean.
* Ci interessa capire il procedimento logico che hai seguito, in questo progetto trovi un file a nome processo-logico.md dove potrai inserire alcune veloci note.

## Hints / FAQ
* I dati nel file NON sono ordinati, né per ProcessId né per Timestamp, l'estrazione su file del nostro cliente è quindi totalmente disordinata. 
* I test sono opzionali, se hai tempo meglio, altrimenti nessun problema. Nel caso tu abbia tempo, ci interessa un test che calcoli la media dei tempi di esecuzione del tuo codice.
* Non ci interessano casi particolari, diamo per scontato che i dati del file siano sempre validi.

## Tech Stack
* Il linguaggio di programmazione è Java (8 o 11). Questo progetto è impostato nel pom.xml su Java 11, se necessario cambia pure la versione.
* Nessun database esterno, nessun framework esterno (Spring, Quarkus, etc), la soluzione deve essere implementata facendo affidamento su Java standard e al massimo un paio di librerie esterne di uso comune (Guava, un qualche parser JSON, apache-commons, etc).
* Per i log basta System.out

## Come contattarci
Per ogni dubbio o per inviare la soluzione (in formato zip), scrivere a: claudio.mazzuco@ifin.it

Grazie !
