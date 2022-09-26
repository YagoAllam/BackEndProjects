package com.epicode.licenze.permessi;

import com.epicode.licenze.titolare.Titolare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class LicenzaAbstract implements Licenza {
	private Titolare titolare;
	private int anno;
	private String operatore;	
}
