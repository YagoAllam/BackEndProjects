1) creare progetto completo
2) aggiungere 3 dipendenze nel pom

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		
3) copiare in application.properties
application.jwtSecret= prgKodecSecretKey
application.jwtExpirationMs=864000000

4) copiare tutti i package dal progetto SicurezzaBaseSB che iniziano per		

it.security.auth

5) creare il runner che genera gli utenti (vedi il runner utenti dentro questo progetto)
6) proteggere i controller con le preautorizzazioni

@PreAuthorize("hasRole('ADMIN')") per abilitare solo agli amministratori
@PreAuthorize("hasRole('USER')") per abilitare solo agli utenti
@PreAuthorize("hasRole('USER')") per abilitare solo agli utenti
@PreAuthorize("isAutenticated()") per abilitare a tutti gli utenti che hanno fatto il login


7) in postman creare una collezione
7.1 fare una request di login da cui copiare il token
7.2 fare login come ADMIN e poi come USER
7.3 fare per ogni rotta del controller una request di postman ricordando di assegnare in auth
il token recuperato. La tipologia è il Bearer token
7.4 testare i vari link