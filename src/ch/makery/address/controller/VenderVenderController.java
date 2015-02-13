package ch.makery.address.controller;



import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Cliente;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;



public class VenderVenderController implements Initializable {

	Main main = new Main();
	Produtos produtos;
	ConectaBanco conecta = new ConectaBanco();
	private ObservableList<Produtos> incluir = FXCollections.observableArrayList();
	static String idCliente;
	static String nome;
	static String idProdutos;
	static String quantEstoque;
	
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
    private TableView<Produtos> tabelaProdutos;

    @FXML
    private TableColumn<Produtos, String> descricao;

    @FXML
    private TableColumn<Produtos, String> unitario;

    @FXML
    private Button buttomLimparVenda;

    @FXML
    private TableColumn<Produtos, String> total;

    @FXML
    private TextField txtCodProduto;

    @FXML
    private Label preçoTotal;

    @FXML
    private TextField txtNVenda;

    @FXML
    private TableColumn<Produtos, String> cod;

    @FXML
    private TableColumn<Produtos, String> quantidade;

    @FXML
    private TextField txtDataVenda;

    @FXML
    void verCodProduto(ActionEvent event) {
    	main.iniciaTelas("view/VerProduto.fxml");

    }

    @FXML
    void verCodCliente(ActionEvent event) {
    	main.iniciaTelas("view/VerClienteCodNome.fxml");

    }

    @FXML
    void confirmar(ActionEvent event) {
    	

    }

    @FXML
    void voltar(ActionEvent event) {
    	idCliente = "";
    	nome = "";
    	quantEstoque = "";
    	idProdutos = "";
    	main.iniciaTelas("view/Vender.fxml");
    }

    @FXML
    void limparVenda(ActionEvent event) {
    	idCliente = "";
    	nome = "";
    	quantEstoque = "";
    	idProdutos = "";
    	main.iniciaTelas("view/VenderVendas.fxml");

    }

    @FXML
    void incluirVenda(ActionEvent event) {
    	String pesquisa = txtCodProduto.getText();
    	try{
    		conecta.conexao();
    		conecta.executaSQL("SELECT * FROM produtos");
    		
    		while(conecta.rs.next()){
    			if (conecta.rs.getString("id_produto").contains(pesquisa)) {
    				incluir.add(new Produtos(String.valueOf(conecta.rs.getString("id_produto")), conecta.rs.getString("descricao_produto"), conecta.rs.getInt("quantidade_produto"),conecta.rs.getFloat("preco_venda")));
    				cod.setCellValueFactory(new PropertyValueFactory<Produtos, String>("id"));
    				descricao.setCellValueFactory(new PropertyValueFactory<Produtos, String>("descricao"));
    				unitario.setCellValueFactory(new PropertyValueFactory<Produtos, String>("pVenda"));
    				tabelaProdutos.setItems(incluir);
    			}
    			conecta.desconecta();
    		}
    	} catch (Exception ex){
    		JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
    	}

    }
    @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		txtcodCliente.setText(idCliente);
   		txtNome.setText(nome);
   		txtDispEstoque.setText(quantEstoque);
   		txtCodProduto.setText(idProdutos);
   		}

}
