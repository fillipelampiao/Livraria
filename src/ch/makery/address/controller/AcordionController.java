package ch.makery.address.controller;


import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

public class AcordionController {
	
	Main main = new Main();
	GeraTabelaProduto geraTabela =  new GeraTabelaProduto();

    @FXML
    private TitledPane buttomConsulta;

    @FXML
    private Button buttomProdutosConsulta;

    @FXML
    private Button buttomTelaInicialCadastro;

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
    private Button buttomTelaInicialRelatorio;

    @FXML
    private Button buttomProdutosCadastro;

    @FXML
    private Button buttomVenderVendas;

    @FXML
    private Button buttomTelaInicialVender;

    @FXML
    private Button buttomAlteraVendaVendas;

    @FXML
    private Button buttomTelaIniciaConsulta;

    @FXML
    private Button buttomEstoqueRelatorio;

    @FXML
    void gruposCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroGrupos.fxml");
    }

    @FXML
    void produtosCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastrarProduto.fxml");
    }

    @FXML
    void fornecedoresCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroFornecedor.fxml");
    }

    @FXML
    void clientesCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroCliente.fxml");
    }

    @FXML
    void funcionariosCadastro(ActionEvent event) {
    	main.iniciaTelas("view/CadastroFuncionario.fxml");
    }

    @FXML
    void telaInicialCadastro(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

    @FXML
    void venderVendas(ActionEvent event) {
    	main.iniciaTelas("view/VenderVendas.fxml");
    }

    @FXML
    void pagamentoPagamento(ActionEvent event) {
    	main.iniciaTelas("view/PagamentoVendas.fxml");
    }

    @FXML
    void alteraVendaVendas(ActionEvent event) {
    	main.iniciaTelas("view/AlterarVender.fxml");
    }

    @FXML
    void telaInicialVender(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

    @FXML
    void gruposConsulta(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaGrupo.fxml");
    }

    @FXML
    void produtosConsulta(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaProduto.fxml");
    }

    @FXML
    void fornecedoresConsulta(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaFornecedor.fxml");
    }

    @FXML
    void clienteConsulta(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaCliente.fxml");
    }

    @FXML
    void funcionariosConsulta(ActionEvent event) {
    	main.iniciaTelas("view/ConsultaFuncionario.fxml");
    }

    @FXML
    void telaIniciaConsulta(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

    @FXML
    void vendasRelatorio(ActionEvent event) {
    	main.iniciaTelas("view/DataInicialFinal.fxml");
    }

    @FXML
    void estoqueRelatorio(ActionEvent event) throws MalformedURLException, DocumentException, IOException, SQLException {
    	geraTabela.VerPdfProduto();

    }

    @FXML
    void telaInicialRelatorio(ActionEvent event) {
    	main.iniciaTelas("view/Inicia.fxml");
    }

}
