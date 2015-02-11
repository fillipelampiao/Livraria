package ch.makery.address.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.postgresql.copy.CopyIn;

import ch.makery.address.Main;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CadastroPodutoController implements Initializable {
	
	Main main = new Main();
	ConectaBanco conecta = new ConectaBanco();
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	
	static String idProduto;
	static String nomeProduto;
	static String pCompra;
	//static String pVenda;
	//static String quantidade;
	//static String outros;
	//static String descricao;
	//static String imagem;

	
	@FXML
    private TextField txtOutros;

    @FXML
    private TextArea txtDescricaoVendas;

    @FXML
    private Button ver;

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
    private TextField txtPrecoVenda;

    @FXML
    private TextField txtPrecoCompra;

    @FXML
    private Button buttomConfirmar;

    @FXML
    private Label codProduto;	    

    @FXML
    void uploadVendas(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	 fileChooser.setTitle("Escolha uma imagem");
    	 fileChooser.getExtensionFilters().addAll(
    			 new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    	 File caminho = fileChooser.showOpenDialog(main.stage);
    	 System.out.println(Main.class.getResource(String.valueOf(caminho)));
    	 if (caminho != null) {
    		
    	 	 
    	 }
    	 
    }

    @FXML
    void limpar(ActionEvent event) {
    	txtNome.setText("");
    	txtPrecoCompra.setText("");
    	txtPrecoVenda.setText("");
    	txtQuantidade.setText("");
    	txtOutros.setText("");
    	codProduto.setText("");
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
    	codProduto.setText("");
    	txtNome.setText("");

    }
    
    @FXML
    void ver(ActionEvent event) {
    	new VerProdutoCadastro().start(new Stage()); 
    	novaTela.iniciarTelaDois("view/VerProdutoCadastro.fxml");
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtNome.setText(nomeProduto);
		codProduto.setText(idProduto);
		//txtQuantidade.setText(quantidade);
	//	txtOutros.setText(outros);
		//txtDescricaoVendas.setText(descricao);
		txtPrecoCompra.setText(pCompra);
		//txtPrecoVenda.setText(pVenda);
		System.out.println(pCompra);
		
	}

}
