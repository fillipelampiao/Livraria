package ch.makery.address.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroPodutoController {
	
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();

    @FXML
    private TextField txtOutros;

    @FXML
    private Button buttomUploadVendas;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Button buttomLimpar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomVoltar;

    @FXML
    private Button buttomAlterarPrecoCompra;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Label codProduto;

    @FXML
    private TextArea txtDescricaoVendas;

    @FXML
    private Button buttomAlterarPrecoVenda;

    @FXML
    private TextField txtPrecoVenda;

    @FXML
    private TextField txtPrecoCompra;

    @FXML
    void alterarPrecoCompra(ActionEvent event) {

    }

    @FXML
    void alterarPrecoVenda(ActionEvent event) {

    }

    @FXML
    void uploadVendas(ActionEvent event) {

    }

    @FXML
    void limpar(ActionEvent event) {
    	txtNome.setText("");
    	txtPrecoCompra.setText("");
    	txtPrecoVenda.setText("");
    	txtQuantidade.setText("");
    	txtOutros.setText("");
    }

    @FXML
    void confirmar(ActionEvent event) {
    	conecta.conexao();
    	try {
			PreparedStatement pst = conecta.conn.prepareStatement("insert into produtos (nome_produto,quantidade_produto, preco_compra, preco_venda,outros_produto, descricao_produto) values(?,?,?,?,?,?)");
	    	Produtos produto = new Produtos(txtNome.getText(),Integer.parseInt(txtQuantidade.getText()),Float.parseFloat(txtPrecoCompra.getText()),
	    									Float.parseFloat(txtPrecoVenda.getText()), txtOutros.getText(),txtDescricaoVendas.getText());
			pst.setString(1,produto.getNome());
			pst.setInt(2, produto.getQuantidade());
	    	pst.setFloat(3, produto.getPCompra());
	    	pst.setFloat(4, produto.getPVenda());
	    	pst.setString(5,produto.getOutros());
	    	pst.setString(6, produto.getDescricao());
	    	pst.executeUpdate();
	    	JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+e);
		}
    	txtNome.setText("");
    	txtPrecoCompra.setText("");
    	txtPrecoVenda.setText("");
    	txtQuantidade.setText("");
    	txtOutros.setText("");
    	txtDescricaoVendas.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Cadastro.fxml");
    }

}
