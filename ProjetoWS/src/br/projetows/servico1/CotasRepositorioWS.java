package br.projetows.servico1;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CotasRepositorioWS {
	CotasDAO cotasDAO;
	public CotasRepositorioWS(){
		cotasDAO = new CotasDAO();
	}
	@WebMethod
	public String[] consultaCotas (String inscricao_nacional){
		Cotas cotas = new Cotas();
		Cotas temp = null;
		String [] vetorCotas = new String[10];
		cotas.setInscricao_nacional(inscricao_nacional);
		temp = cotasDAO.consulta(cotas);
		if (temp != null){
			vetorCotas[1] = temp.getInscricao_nacional();
			vetorCotas[2] = temp.getNome();
			vetorCotas[3] = temp.getGrupo();
			vetorCotas[4] = Integer.toString(temp.getCota());
			vetorCotas[5] = Integer.toString(cotas.getVersao());
		}
		return vetorCotas;
	}
}