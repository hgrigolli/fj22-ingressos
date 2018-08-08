package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentroSobre(precoOriginal));
	}

	private BigDecimal trintaPorCentroSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal("0.3"));
	}

	@Override
	public String getDescricao() {
		return "BANCO";
	}

}
