package ch.makery.address;


import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import ch.makery.address.Main;
import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.GeraTabelaProduto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	ConectaBanco conecta = new ConectaBanco();
	static BorderPane borde;
	public static Stage stage;
	GeraTabelaProduto gera = new GeraTabelaProduto();
	
	private String primaria = "view/Acordion.fxml";
	private String secundaria = "view/Inicia.fxml";
	
	@Override
	public void start(Stage stage) throws MalformedURLException, DocumentException, SQLException, IOException {
		this.stage = stage;
		conecta.conexao();
		
		iniciaAcordion(primaria);
		
		iniciaTelas(secundaria);
		gera.geraPdf();
		
	}
	//Inicia tela acordion 
    public void iniciaAcordion(String primaria) {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(primaria));
            borde = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo oroot layout.
            Scene scene = new Scene(borde);
            stage.setScene(scene);
            stage.setResizable(false);     
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void iniciaTelas(String secundaria){
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(secundaria));
            AnchorPane pane = (AnchorPane) loader.load();
           
            borde.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
