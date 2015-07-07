package br.projetows.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.projetows.servico1.Cotas;
import br.projetows.servico1.CotasDAO;

public class UC01CadastrarCotas {
static CotasDAO cotasDAO;
static Cotas cotas;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		cotasDAO = new CotasDAO();
		cotas = new Cotas();
		cotas.setInscricao_nacional("1111111111");
		cotas.setNm_pessoa("jose da silva");
		cotas.setGrupo("codigo grupo");
		cotas.setCota(1111);
		cotas.setVersao(1111);
		
	}
	@Test
	public void CT01UC01CadastraCota_com_sucesso() {
		cotasDAO.exclui("1111111111");
		assertEquals("Cadastro realizado com sucesso",cotasDAO.cadastra(cotas));
	}
	@Test
	public void CT02UC01CadastraCota_sem_sucesso() {
		cotasDAO.cadastra(cotas);
		assertEquals("Erro no cadastro",cotasDAO.cadastra(cotas));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//cotasDAO.exclui("1111111111");
	}

	
}

