package ch.makery.address.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class VenderVenderController {

    @FXML
    private TextField txtcodCliente;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Button buttomVerCodProduto;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomVoltar;

    @FXML
    private ToggleGroup vistaprazo;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private TextField txtDispEstoque;

    @FXML
    private Button buttomVerCodCliente;

    @FXML
    private Button buttomIncluirVenda;

    @FXML
    private TableView<?> tabelaProdutos;

    @FXML
    private TableColumn<?, ?> descricao;

    @FXML
    private TableColumn<?, ?> unitario;

    @FXML
    private Button buttomLimparVenda;

    @FXML
    private TableColumn<?, ?> total;

    @FXML
    private TextField txtCodProduto;

    @FXML
    private Label preçoTotal;

    @FXML
    private TextField txtNVenda;

    @FXML
    private TableColumn<?, ?> cod;

    @FXML
    private TableColumn<?, ?> quantidade;

    @FXML
    private TextField txtDataVenda;

    @FXML
    void verCodProduto(ActionEvent event) {

    }

    @FXML
    void verCodCliente(ActionEvent event) {

    }

    @FXML
    void confirmar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void limparVenda(ActionEvent event) {

    }

    @FXML
    void incluirVenda(ActionEvent event) {

    }

}
