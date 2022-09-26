package com.epicode.pattern.adapter;


public class UserData {
   	private String nomeCompleto; 
	 private int eta; 
	 
	 public void getData(DataSource ds) { 
	 nomeCompleto = ds.getNomeCompleto (); 
	 eta = ds.getEta(); 
	 }
}
