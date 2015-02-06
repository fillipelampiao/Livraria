package PagamentoVender;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class PagamentoVenderController {

    @FXML
    private TextField txtCodCliente;

    @FXML
    private TableColumn<?, ?> tabNuVenda;

    @FXML
    private TableColumn<?, ?> tabData;

    @FXML
    private Button buttomConfirmarVendas;

    @FXML
    private TableColumn<?, ?> tabDebito;

    @FXML
    private Button buttomLimparVendas;

    @FXML
    private TableColumn<?, ?> tabProduto;

    @FXML
    private TableColumn<?, ?> tabTotal;

    @FXML
    private Button buttomVerCodCliente;

    @FXML
    private TextField txtCliente;

    @FXML
    private Button buttomVoltarInicial;

    @FXML
    private TableColumn<?, ?> tabQuantidade;

    @FXML
    void voltarInicial(ActionEvent event) {

    }

    @FXML
    void limparVendas(ActionEvent event) {

    }

    @FXML
    void confirmarVendas(ActionEvent event) {

    }

    @FXML
    void verCodCliente(ActionEvent event) {

    }

}
