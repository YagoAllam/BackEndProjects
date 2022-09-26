package com.epicode.licenze.permessi;

import com.epicode.licenze.titolare.Titolare;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LicenzaCaccia extends LicenzaAbstract {

		private String arma;

		public LicenzaCaccia(Titolare titolare, int anno, String operatore, String arma) {
			super(titolare, anno, operatore);
			this.arma = arma;
		}

		

		
		

}
