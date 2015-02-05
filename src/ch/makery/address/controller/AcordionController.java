package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class AcordionController {
	
	Main main = new Main();

    @FXML
    private TitledPane buttomConsulta;

    @FXML
    private Button buttomProdutosConsulta;

    @FXML
    private Button buttomFuncionariosConsulta;

    @FXML
    private Button buttomGruposCadastro;

    @FXML
    private Button buttomClientesCadastro;

    @FXML
    private Button buttomFornecedoresConsulta;

    @FXML
    private TitledPane buttomRelatorio;

    @FXML
    private Button buttomVendasRelatorio;

    @FXML
    private Button buttomClientesConsulta;

    @FXML
    private Button buttomFornecedoresCadastro;

    @FXML
    private Button buttomFuncionariosCadastro;

    @FXML
    private Button buttomPagamentoPagamento;

    @FXML
    private Button buttomGruposConsulta;

    @FXML
    private TitledPane buttomCadastrar;

    @FXML
    private TitledPane buttomVendas;

    @FXML
    private Button buttomProdutosCadastro;

    @FXML
    private Button buttomVenderVendas;

    @FXML
    private Button buttomAlteraVendaVendas;

    @FXML
    private Button buttomEstoqueRelatorio;

    @FXML
    void gruposCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroGrupos.fxml");
    }

    @FXML
    void produtosCadastro(ActionEvent event) {

    }

    @FXML
    void fornecedoresCadastro(ActionEvent event) {

    }

    @FXML
    void clientesCadastro(ActionEvent event) {

    }

    @FXML
    void funcionariosCadastro(ActionEvent event) {

    }

    @FXML
    void venderVendas(ActionEvent event) {

    }

    @FXML
    void pagamentoPagamento(ActionEvent event) {

    }

    @FXML
    void alteraVendaVendas(ActionEvent event) {

    }

    @FXML
    void gruposConsulta(ActionEvent event) {

    }

    @FXML
    void produtosConsulta(ActionEvent event) {

    }

    @FXML
    void fornecedoresConsulta(ActionEvent event) {

    }

    @FXML
    void clientesConsulta(ActionEvent event) {

    }

    @FXML
    void funcionariosConsulta(ActionEvent event) {

    }

    @FXML
    void vendasRelatorio(ActionEvent event) {

    }

    @FXML
    void estoqueRelatorio(ActionEvent event) {

    }

}
