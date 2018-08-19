package br.com.Blogger.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.Blogger.model.DataPost;
import br.com.Blogger.model.ListNews;
import br.com.Blogger.view.GerenciadorView;




public class CadastroController implements Initializable{

	@FXML
	TextField txtAutor;
	@FXML
	ComboBox<String> cboTema = new ComboBox<String>() ;
	@FXML
	TextArea txtConteudo;
	@FXML
	TextField txtTitulo;
	@FXML
	Button btnImagem;
	@FXML
	Button btnPostar;
	@FXML
	Label txtID;

	public static int id = 1;
	@FXML Label txtRest;
	@FXML Button btnVisualizar;

	Image imagemPost = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cboTema.getItems().add("Política");
		cboTema.getItems().add("Cultura");
		cboTema.getItems().add("Ciências e Tecnologias");
		cboTema.getItems().add("Economia");
		cboTema.getItems().add("Educação");
		cboTema.getItems().add("Esportes");
		cboTema.getItems().add("Internacional");
		cboTema.getItems().add("Entretenimento");

		int maxLength = 1000;
		txtConteudo.textProperty().addListener(x->{
			if (txtConteudo.getText().length() > maxLength) {
                String s = txtConteudo.getText().substring(0, maxLength);
                txtConteudo.setText(s);
            }
			int rest =  maxLength - txtConteudo.getText().length();
    		txtRest.setText("Restam "+rest+" caracteres");
    		});


		btnVisualizar.setDisable(true);
	}


	@FXML public String selectCategoria() {


		String selTema = cboTema.getSelectionModel() .getSelectedItem();
		System.out.println(selTema);

		return selTema;
	}


	@FXML public void Post() {


		String autor = txtAutor.getText();
		String titulo = txtTitulo.getText();
		String conteudo = txtConteudo.getText();
		String tema = selectCategoria();

		DataPost dados = new DataPost();
		dados.setAutor(autor);
		dados.setTitulo(titulo);
		dados.setId(id);
		dados.setTema(tema);
		dados.setConteudo(conteudo);
		Date data = new Date();
		dados.setData(data);

		if( imagemPost != null )
			dados.setImagem( imagemPost );


		txtID.setText("ID "+ id);

		System.out.println("Postar");
		System.out.println("Tema: "+tema);
		System.out.println(autor);
		System.out.println(titulo);
		System.out.println(conteudo);
		System.out.println(id);
		System.out.println(data);

		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dados.getData());
		String horaFormatada = new SimpleDateFormat("HH:mm:ss").format(dados.getData());
		System.out.println(dataFormatada);
		System.out.println(horaFormatada);
;

		if(txtAutor.getText().isEmpty() ||
				txtTitulo.getText().isEmpty() ||
				txtConteudo.getText().isEmpty() ||
				cboTema.getValue()==null

		){
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Preencha todos os campos!");
			msg.setHeaderText("Erro de validação");
			msg.show();
			return;
		}

		if(imagemPost == null){
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Selecione uma imagem!");
			msg.setHeaderText("Erro de validação");
			msg.show();
			return;
		}

		id++;



		ListNews.getLstNews().add(dados);


		//mensagem de sucesso
		Alert msg = new Alert(AlertType.INFORMATION);
		msg.setContentText("Postado com sucesso.");
		msg.setHeaderText("Sucesso");
		msg.show();

		//Limpar caixas de texto
		txtTitulo.setText("");
		txtAutor.setText("");
		txtConteudo.setText("");
		cboTema.setValue(null);

		btnVisualizar.setDisable(false);

	}


	@FXML public void btnImage() {

		//objeto que abre o windows explorer
				FileChooser explorer = new FileChooser();

				//Filtro de extensões de arquivo
				explorer.getExtensionFilters().add(
						new ExtensionFilter("Imagens", "*jpg","*png", "*gif")
				);

				//obter a janela atual
				Window janela = btnImagem.getScene().getWindow();

				//abrir o explorer para escolher arquivo
				File arquivo = explorer.showOpenDialog(janela);

				System.out.println(arquivo);

				imagemPost = new Image(String.format("file:%s", arquivo.getAbsolutePath()));


	}


	@FXML public void Visualizar() {
		GerenciadorView janela = new GerenciadorView();
		Stage stage =(Stage) btnImagem.getScene().getWindow();
		janela.openScreen(stage, "Visualizacao.fxml");

	}







}
