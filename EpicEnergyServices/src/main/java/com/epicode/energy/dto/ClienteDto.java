package com.epicode.energy.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.epicode.energy.models.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
	
	private String ragioneScociale;
	private String partitaIva;
	private String email;
	

	private Date dataInserimento;
	

	private Date dataUltimoContatto;
	private int FatturatoAnnuale;
	private String pec;
	private String telefono;
	

	private String nomeContatto;
	

	private String cognomeContatto;
	private String telefonoContatto;
	
	
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;


	public String[] getNullProperties() {
		List<String> nullProps = new ArrayList<String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field f : fields) {
			try {
				Object value = f.get(this);
				Class type = f.getType();
				if(value == null) {
					nullProps.add(f.getName());
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		String[] res = new String[nullProps.size()];
		for(int i = 0; i < nullProps.size(); i++) {
			res[i] = nullProps.get(i);

		}
		
		
		
		return res;
	}
	



}