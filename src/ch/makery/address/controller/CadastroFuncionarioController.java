package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController {
	
	Main main = new Main();

    @FXML
    private Button buttomConfirmarFuncionario;

    @FXML
    private TextField txtEmailFuncionario;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private TextField txtCpfFuncionario;

    @FXML
    private Button buttomLimparFuncionario;

    @FXML
    private TextField txtOutrosFuncionario;

    @FXML
    private TextField txtRgFuncionario;

    @FXML
    private TextField txtSenhaFuncionario;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    void limparFuncionario(ActionEvent event) {

    }

    @FXML
    void confirmarFuncionario(ActionEvent event) {

    }

    @FXML
    void voltarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

}
