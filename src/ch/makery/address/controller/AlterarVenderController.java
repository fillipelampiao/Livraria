package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AlterarVenderController {

	Main main = new Main();
	
    @FXML
    private TextField txtNumeroCompra;

    @FXML
    private Button buttomVerNumeroCompra;

    @FXML
    private Label data;

    @FXML
    private Button buttomEditar;

    @FXML
    private Button buttomVoltar;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Button buttomVerCodCliente;

    @FXML
    private TextField txtCliente;

    @FXML
    private TableColumn<?, ?> unitario;

    @FXML
    private TextField txtCodCliente;

    @FXML
    private TableColumn<?, ?> total;

    @FXML
    private TableColumn<?, ?> produto;

    @FXML
    private Button buttomExcluir;

    @FXML
    private TableColumn<?, ?> quantidade;

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Vender.fxml");
    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void confirmar(ActionEvent event) {

    }

    @FXML
    void verCodCliente(ActionEvent event) {

    }

    @FXML
    void verNumeroCompra(ActionEvent event) {

    }

}
