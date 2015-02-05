package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroClienteController {
	
	Main main = new Main();

    @FXML
    private Button buttomConfirmarCliente;

    @FXML
    private TextField txtCodCliente;

    @FXML
    private TextField txtEmailCliente;

    @FXML
    private TextField txtFoneCliente;

    @FXML
    private TextField txtRgCliente;

    @FXML
    private TextField txtCpfCliente;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtOutrosCliente;

    @FXML
    private Button buttomLimparCliente;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    void limparCliente(ActionEvent event) {

    }

    @FXML
    void confirmarCliente(ActionEvent event) {

    }

    @FXML
    void voltarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

}
