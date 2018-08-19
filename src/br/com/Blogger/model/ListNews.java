package br.com.Blogger.model;

import java.util.ArrayList;
import java.util.List;

import br.com.Blogger.controller.CadastroController;



public class ListNews extends CadastroController{
	private static List<DataPost> lstNEWS = new ArrayList<>();

	public static List<DataPost> getLstNews() {
		return lstNEWS;
	}

	public void setLstData(List<DataPost> lstN) {
		ListNews.lstNEWS = lstN;
	}
}
