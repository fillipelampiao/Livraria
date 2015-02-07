package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class PagamentoVenderController {
	
	Main main = new Main();

    @FXML
    private TextField txtCodCliente;

    @FXML
    private TableColumn<?, ?> debito;

    @FXML
    private TableColumn<?, ?> total;

    @FXML
    private TableColumn<?, ?> data;

    @FXML
    private TableColumn<?, ?> produto;

    @FXML
    private Button buttomPagar;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TableColumn<?, ?> nuVenda;

    @FXML
    private Button buttomVerCodCliente;

    @FXML
    private TextField txtCliente;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    void voltarInicial(ActionEvent event) {
    	main.iniciaTelas("view/Vender.fxml");
    }

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void pagar(ActionEvent event) {

    }

    @FXML
    void verCodCliente(ActionEvent event) {

    }

}
