package it.epicode.multimedia.player;

import java.util.Scanner;

public class Program {

	/*
	 * il codice di un lettore multimediale che memorizza 5 elementi (creati con
	 * valori letti da tastiera) in un array e poi chiede ripetutamente all'utente
	 * quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire).
	 */

	public static Scanner scanner = new Scanner(System.in);

	public static int readInt() {
		return Integer.parseInt(scanner.nextLine());
	}

	public static String readString() {
		return scanner.nextLine();
	}

	static void gestisciElement(Multimedia m) {
		// visualizzi il video, l'immagine o l'audio

		// se è immagine utilizzza il metodo show()
		if (m instanceof VisualizzaElemento) {
			((VisualizzaElemento) m).show();

			// se è video o audio utilizza il metodo play()
		} else if (m instanceof RiproduciElemento) {
			((RiproduciElemento) m).play();
		}

	}

	static void creaImmagine(String title, int lum) {
		Immagine nuovaImmagine = new Immagine(title, lum);

	}

	public static void main(String[] args) {

		/**
		 * creare un array media che è una istanza della classe Multimedia con 5
		 * elementi multimediali (video, audio o immagine) Essi sono istanze delle sotto
		 * classi [Video, Audio o Immagine]
		 * 
		 */
		Multimedia[] media = new Multimedia[] { new Immagine("myPhoto", 2), new Video("myVideo", 2, 3, 4),
				new Audio("Myaudio", 0, 0), new Video("myVideo2", 1, 5, 4), new Immagine("myPhoto2", 5) };

		System.out.println("Cosa vuoi creare=");
		int scelta = readInt();
		switch (scelta) {

		case 1: // crea immagine

			creaImmagine("myPhoto", 5);

		case 2: // crea audio
		case 3: // crea video
		}

		// chiedi cosa vuole visualizzare
		gestisciElement(media[1]);

	}

}