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
    private Button confirmarGrupos;

    @FXML
    private ToggleGroup cf;

    @FXML
    private TextField txtNomeGrupo;

    @FXML
    private TextField txtOutrosGrupos;

    @FXML
    private Button buttomLimparGrupos;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    void limparGrupos(ActionEvent event) {

    }

    @FXML
    void confirmarGrupos(ActionEvent event) {

    }

    @FXML
    void voltarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

}
