package br.com.caelum.ingresso.validacao;

import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private static boolean isConflitante(Sessao sessaoNova, Sessao sessaoExistente) {
		boolean novaTerminaAntesDaExistente = sessaoNova.getHorarioTermino().isBefore(sessaoExistente.getHorario());
		boolean novaComecaDepoisDaExistente = sessaoNova.getHorario().isAfter(sessaoExistente.getHorarioTermino());
		
		if(novaTerminaAntesDaExistente || novaComecaDepoisDaExistente) {
			return false;
		}
		
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova) {
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> isConflitante(sessaoNova, sessaoExistente));
	}
}
