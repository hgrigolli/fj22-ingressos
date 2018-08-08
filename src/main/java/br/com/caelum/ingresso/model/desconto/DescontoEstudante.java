package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoEstudante implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		return precoOriginal.divide(new BigDecimal("2.0"));
	}
	

}
