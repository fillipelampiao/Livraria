package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CadastroGruposController {

	Main main = new Main();
	
    @FXML
    private TextField txtOutros;

    @FXML
    private ToggleGroup cf;

    @FXML
    private Button confirmar;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomVoltar;

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void confirmar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

}
