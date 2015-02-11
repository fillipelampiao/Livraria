package ch.makery.address.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Grupos;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.VerProdutoCadastro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VerProdutoCadastroController implements Initializable{
	
	static String idProduto;
	static String nomeProduto;
	static String pCompra;
	//static String pVenda;
	//static String quantidade;
	//static String outros;
	//static String descricao;
	//static String imagem;
	
	
	VerProdutoCadastro verProdutoCadastro = new VerProdutoCadastro();
	CadastroPodutoController cadastroProduto = new CadastroPodutoController();
	Main main = new Main();
	
	ConectaBanco conecta =  new ConectaBanco();
	
	private ObservableList<Produtos> produtos = FXCollections.observableArrayList();
	
    @FXML
    private Button buttomPesquisar;
    
    @FXML
    private TableView<Produtos> tabela;

    @FXML
    private TableColumn<Produtos, String> cod;

    @FXML
    private TextField txtNome;

    @FXML
    private Button butomVoltar;

    @FXML
    private TableColumn<Produtos, String> nome;

    @FXML
    private Button buttomConfirmar;

    @FXML
    void pesquisar(ActionEvent event) {
    	produtos.clear();
    	conecta.conexao();
		conecta.executaSQL("select * from produtos");
		try {
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_produto").contains(txtNome.getText())) {
					produtos.add(new Produtos(String.valueOf(conecta.rs.getInt("id_produto")),conecta.rs.getString("nome_produto")));
					cod.setCellValueFactory(new PropertyValueFactory<Produtos, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));
					tabela.setItems(produtos);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Produto nao encontrado!");
		}
    }

    @FXML
    void confirmar(ActionEvent event) {
    	if (tabela.getSelectionModel().getSelectedItem() != null ){
    		Produtos c = tabela.getSelectionModel().getSelectedItem();
    		nomeProduto = c.getNome();
    		idProduto = c.getId();
    		int codProd = 2;
    		conecta.conexao();
			conecta.executaSQL("select * from produtos where id_produto='"+codProd+"'");
			System.out.println(codProd);
    		try {
				pCompra = String.valueOf(conecta.rs.getFloat("preco_compra"));
			} catch (SQLException e) {
				
			}
    		//pVenda = String.valueOf(c.getPVenda());
    		//quantidade = String.valueOf(c.getQuantidade());
    		//outros = c.getOutros();
    		//descricao = c.getDescricao();
    		//imagem = c.getImagem();
    		
    		
    		CadastroPodutoController.nomeProduto = nomeProduto;
    		CadastroPodutoController.idProduto = idProduto;
    		CadastroPodutoController.pCompra = pCompra;
    		//CadastroPodutoController.pVenda = pVenda;
    		//CadastroPodutoController.quantidade = quantidade;
    		//CadastroPodutoController.outros = outros;
    		//CadastroPodutoController.descricao = descricao;
    		//CadastroPodutoController.imagem = imagem;
    		
    		
    	main.stage.close();
    	main.iniciaAcordion("view/Acordion.fxml");
    	main.iniciaTelas("view/CadastrarProduto.fxml");
    	verProdutoCadastro.stage2.close();
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	verProdutoCadastro.stage2.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conecta.conexao();
		conecta.executaSQL("select * from produtos");
	
		try {
			while (conecta.rs.next()) {
				produtos.add(new Produtos(String.valueOf(conecta.rs.getInt("id_produto")),conecta.rs.getString("nome_produto")));
				cod.setCellValueFactory(new PropertyValueFactory<Produtos, String>("id"));
				nome.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));
				tabela.setItems(produtos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
