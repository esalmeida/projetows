package br.projetows.servico1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cotas {
	@Id
	String inscricao_nacional;
	String nm_pessoa;
	String grupo;
	int cota;
	int versao;
	public String getInscricao_nacional() {
		return inscricao_nacional;
	}
	public void setNm_pessoa(String nome){
		nm_pessoa = nome;
	}
	public String getNome(){
		return nm_pessoa;
	}
	public void setInscricao_nacional(String inscricao_nacional) {
		this.inscricao_nacional = inscricao_nacional;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getCota() {
		return cota;
	}
	public void setCota(int cota) {
		this.cota = cota;
	}
	public int getVersao() {
		return versao;
	}
	public void setVersao(int versao) {
		this.versao = versao;
	}
	

}
