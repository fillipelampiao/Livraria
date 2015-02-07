package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IniciaController {

	Main main = new Main();
	
    @FXML
    private Button buttomCadastrarInicial;

    @FXML
    private Button buttomrelatorioInicial;

    @FXML
    private Button buttomLogoff;

    @FXML
    private Button buttomconsultarInicial;

    @FXML
    private Button buttomRegistrarInicial;

    @FXML
    void cadastrarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

    @FXML
    void registrarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Vender.fxml");
    }

    @FXML
    void consultarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

    @FXML
    void relatorioInicial(ActionEvent event) {
    	main.iniciaTelas("view/Relatorio.fxml");
    }

    @FXML
    void logoffInicial(ActionEvent event) {
    	
    }

}
