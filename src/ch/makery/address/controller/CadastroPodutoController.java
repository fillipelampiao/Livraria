package ch.makery.address.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroPodutoController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	
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
    private TextField txtCod;

    @FXML
    private Button buttomAlterarPrecoCompra;

    @FXML
    private Button buttomConfirmar;

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
			PreparedStatement pst = conecta.conn.prepareStatement("insert into produtos (nome_produto, preco_compra, preco_venda, quantidade_produto, outros_produto, descricao_produto) values(?,?,?,?,?,?)");
	    	pst.setString(1, txtNome.getText());
	    	pst.setFloat(2, Float.parseFloat(txtPrecoCompra.getText()));
	    	pst.setFloat(3, Float.parseFloat(txtPrecoVenda.getText()));
	    	pst.setFloat(4, Float.parseFloat(txtQuantidade.getText()));
	    	pst.setString(5, txtOutros.getText());
	    	pst.setString(6, txtDescricaoVendas.getText());
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
