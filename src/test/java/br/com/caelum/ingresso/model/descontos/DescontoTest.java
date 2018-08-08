package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.desconto.DescontoEstudante;
import br.com.caelum.ingresso.model.desconto.DescontoParaBancos;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public class DescontoTest {
	
	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	private Ingresso ingresso;
	private BigDecimal precoEsperado;
	private Lugar lugar;
	
	
	@Before
	public void preparaDesconto() {
		this.lugar = new Lugar("A", 1);
		this.sala = new Sala("Sala IMAX", new BigDecimal("20.5"));
		this.filme = new Filme("Rogue One", Duration.ofMinutes(120), "Fantasy", new BigDecimal("12"));
		this.sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		
		ingresso = new Ingresso(sessao, new SemDesconto());	
		precoEsperado = new BigDecimal("32.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	@Test
	public void deveConceder30PorCentoDeDescontoParaClientesDeBancos() {
		
		ingresso = new Ingresso(sessao, new DescontoParaBancos());
		precoEsperado = new BigDecimal("22.75");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
		
	}
	
	
	@Test
	public void deveConceder50PorCentoDeDescontoParaEstudantes() {
		
		ingresso = new Ingresso(sessao, new DescontoEstudante());
		precoEsperado = new BigDecimal("16.25");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
