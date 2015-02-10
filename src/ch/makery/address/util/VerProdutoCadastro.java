package ch.makery.address.util;

import java.io.IOException;



import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ch.makery.address.Main;
import ch.makery.address.model.Produtos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VerProdutoCadastro extends Application {
	
	ConectaBanco conecta = new ConectaBanco();
	public static Stage stage2;
	private Pane pane2;
	String caminho = "view/VerProdutoCadastro.fxml";


	public void start(Stage stage2){
		this.stage2 = stage2;
		conecta.conexao();
		iniciarTelaDois(caminho);
				
	}
	public void iniciarTelaDois(String caminho){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(caminho));
			pane2 = (Pane) loader.load();
			stage2.setResizable(false); 
			stage2.setTitle("Clientes");
			
			Scene cena = new Scene (pane2);
			stage2.setScene(cena);
			stage2.show();	
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		}
	

}
