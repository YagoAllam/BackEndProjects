package com.epicode.gestionelibri.services;

public class Singleton {
	private static Singleton instance = new Singleton();
	public static Singleton getIstance() {
		return instance;
	}
	
	private Singleton() {}
	
	
	
}
