package br.com.Blogger.view;

import java.io.IOException;

import br.com.Blogger.view.GerenciadorView;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		GerenciadorView janela = new GerenciadorView();

		janela.openScreen(primaryStage, "Cadastro.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
