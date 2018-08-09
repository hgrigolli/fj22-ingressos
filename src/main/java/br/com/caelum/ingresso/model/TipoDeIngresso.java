package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;
import br.com.caelum.ingresso.model.desconto.DescontoEstudante;
import br.com.caelum.ingresso.model.desconto.DescontoParaBancos;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public enum TipoDeIngresso {
	
	INTEIRA(new SemDesconto()),
	MEIA(new DescontoEstudante()),
	BANCOS(new DescontoParaBancos());
	
	private final Desconto desconto;
	
	private TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDesconto(valor);
	}
	
	public String getDescricao() {
		return desconto.getDescricao();
	}

}
