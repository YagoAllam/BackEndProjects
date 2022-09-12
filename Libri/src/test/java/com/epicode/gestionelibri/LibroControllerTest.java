package com.epicode.gestionelibri;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class LibroControllerTest {
	@Autowired
	private TestRestTemplate restTemplate ;
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	@Qualifier("TestBean")
	ObjectProvider<Libro> libroProvider;
	
	@Autowired
	@Qualifier("TestLibroDto")
	ObjectProvider<LibroDto> libroDtoProvider;
	
	public final static String ENTRY_POINT = "http://localhost:8080/v2/libri";
	
	// trovaById
	
	@Test
	@DisplayName("Cerca un libro specificando l'id e lo trovo")
	public void trovaByIdSuccessTest() {
		Libro nuovoLibro = libroProvider.getObject();
		libroRepository.save(nuovoLibro);
		// http://localhost:8080/libri/100
		String url = ENTRY_POINT+"/"+nuovoLibro.getId() ;
		
		
		ResponseEntity<Libro> re = restTemplate.getForEntity(url, Libro.class);
		Libro libroTrovato = re.getBody();
		
		assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(libroTrovato.getId()).isEqualTo( nuovoLibro.getId() );
		
	}
	
	@Test
	@DisplayName("Cerco un libro inesistente e mi aspetto un 404 not found")
	public void trovaByIdNotFoundTest() {
		String url = ENTRY_POINT +  "/100000" ;
		
		ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
		assertThat(re.getStatusCode()).isEqualTo(  HttpStatus.NOT_FOUND );
		
	}
	
	// crea
	@Test
	@DisplayName("Creo un nuovo libro con successo usando il dto")
	public void creaLibroSuccessTest() {
		String url = ENTRY_POINT ;
		LibroDto dto = libroDtoProvider.getObject() ;
		HttpEntity<LibroDto> le = new HttpEntity<LibroDto>( dto );
		
		ResponseEntity<Libro> re = restTemplate.postForEntity(url, le, Libro.class );
		Libro libroCreato = re.getBody();
		assertThat(re.getStatusCode()).isEqualTo(  HttpStatus.OK  );
		
		assertThat(libroCreato.getTitolo()).isEqualTo(   dto.getTitolo()  ); 
		
		
	}
	
	@Test
	@DisplayName("Creo un nuovo libro usando il titolo di un libro esistente e mi aspetto uno status 302 = found")
	public void creaLibroErrorTest() {
		String url = ENTRY_POINT ;
		LibroDto dto = libroDtoProvider.getObject() ;
		HttpEntity<LibroDto> le = new HttpEntity<LibroDto>( dto );
		
		ResponseEntity<Libro> re = restTemplate.postForEntity(url, le, Libro.class );
		ResponseEntity<String> re1  = restTemplate.postForEntity(url, le, String.class );
		
		assertThat(re1.getStatusCode()).isEqualTo( HttpStatus.FOUND );
		
	}

}
