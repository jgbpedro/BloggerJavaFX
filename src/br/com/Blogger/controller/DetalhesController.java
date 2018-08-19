package br.com.Blogger.controller;

import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.com.Blogger.model.Comentarios;
import br.com.Blogger.model.DataPost;
import br.com.Blogger.model.DataPostStatic;
import br.com.Blogger.view.GerenciadorView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;



public class DetalhesController implements Initializable{

	@FXML Label txtDtema;
	@FXML Label txtDtitulo;
	@FXML Label txtTempo;
	@FXML ImageView imgDet;
	@FXML TextFlow txtPost;
	@FXML TextField txtDnome;
	@FXML TextArea txtComentar;
	@FXML Button btnComentar;
	@FXML ListView<Comentarios> lstComentarios;
	@FXML Button btnNew;
	@FXML Button btnReturn;
	@FXML Label txtConteudoP;

	DataPost dadosCad = null;


	public void initialize(URL location, ResourceBundle resources) {
		String autor = DataPostStatic.estatica.getAutor();
		txtDtitulo.setText(DataPostStatic.estatica.getTitulo());
		txtDtema.setText(DataPostStatic.estatica.getTema());
		txtConteudoP.setText(DataPostStatic.estatica.getConteudo());
		imgDet.setImage(DataPostStatic.estatica.getImagem());
		DataPostStatic.estatica.getData();

		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(DataPostStatic.estatica.getData());
		String horaFormatada = new SimpleDateFormat("HH:mm:ss").format(DataPostStatic.estatica.getData());
		txtTempo.setText("Postado por "+autor+" dia "+dataFormatada+" às "+horaFormatada);
	}


	@FXML public void Comentar() {
		Date data = new Date();

		String nome = txtDnome.getText();
		String comentario = txtComentar.getText();
		
		Comentarios comentar = new Comentarios();
		comentar.setNomeComment(nome);
		comentar.setComentario(comentario);
		comentar.setDataComment(data);
		
		System.out.println(txtDnome);
		System.out.println(txtComentar);
		
		if(txtDnome == null || txtComentar == null){
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Preencha todos os campos!");
			msg.setHeaderText("Erro de validação");
			msg.show();
			return;
		
		}
		
		lstComentarios.getItems().add(comentar);



	}

	@FXML public void NovaPostagem() {
		GerenciadorView janela = new GerenciadorView();
		Stage stage =(Stage) btnComentar.getScene().getWindow();
		janela.openScreen(stage, "Cadastro.fxml");
	}
	@FXML public void Voltar() {
		GerenciadorView janela = new GerenciadorView();
		Stage stage =(Stage) btnNew.getScene().getWindow();
		janela.openScreen(stage, "Visualizacao.fxml");
	}


}
