package com.epicode.pattern.adapter;

public class Adapter implements DataSource {

	private Info info;


	@Override
	public String getNomeCompleto() {
		 
		return info.getNome() + " " + info.getCognome(); 
	}

	@Override
	public int getEta() {
		// TODO Auto-generated method stub
		return 0;
	}
   
	
	public Adapter (Info info) {
		this.info = info;
	}
	
}
