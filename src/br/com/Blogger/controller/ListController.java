package br.com.Blogger.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.Blogger.model.DataPost;
import br.com.Blogger.model.DataPostStatic;
import br.com.Blogger.model.ListNews;
import br.com.Blogger.view.GerenciadorView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ListController implements Initializable {


	@FXML ListView<DataPost> lstNews;
	@FXML Button btnDetalhes;
	@FXML Button btnNpostagem;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub


		//acessando a lista estatica
		for(DataPost item : ListNews.getLstNews()){

			lstNews.getItems()
				.add(item);

		}


	}


	@FXML public void VerDetalhes() {
		DataPostStatic.estatica = lstNews.getSelectionModel().getSelectedItem();

		if(lstNews.getSelectionModel().getSelectedItem()==null){
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Selecione um item!");
			msg.setHeaderText("Erro de validação");
			msg.show();
			return;

		}

		System.out.println(lstNews.getSelectionModel().getSelectedItem());

		GerenciadorView janela = new GerenciadorView();
		Stage stage =(Stage) btnNpostagem.getScene().getWindow();
		janela.openScreen(stage, "Detalhes.fxml");
	}

	@FXML public void NovaPostagem() {
		GerenciadorView janela = new GerenciadorView();
		Stage stage =(Stage) btnNpostagem.getScene().getWindow();
		janela.openScreen(stage, "Cadastro.fxml");
	}


}