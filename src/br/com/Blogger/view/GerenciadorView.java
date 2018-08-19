package br.com.Blogger.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciadorView {

	public void openScreen(Stage stage, String fxml){

		Parent root;
		try {
			root = FXMLLoader.load(
					getClass().getResource(fxml));

			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
