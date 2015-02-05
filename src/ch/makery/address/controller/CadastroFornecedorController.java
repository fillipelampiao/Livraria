package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroFornecedorController {
	
	Main main = new Main();

    @FXML
    private TextField txtCpfCnpjFornecedor;

    @FXML
    private TextField txtEmailFornecedor;

    @FXML
    private TextField txtNomeFornecedor;

    @FXML
    private TextField txtOutrosFornecedor;

    @FXML
    private Button buttomLimparFornecedor;

    @FXML
    private TextField txtFoneFornecedor;

    @FXML
    private Button buttomConfirmarFornecedor;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    void limparFornecedor(ActionEvent event) {

    }

    @FXML
    void confirmarFornecedor(ActionEvent event) {

    }

    @FXML
    void voltarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

}
