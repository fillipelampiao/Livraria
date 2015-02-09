package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Cliente;
import ch.makery.address.model.Produtos;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaProdutoController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	int del;
	private ObservableList<Produtos> produtodados = FXCollections.observableArrayList();

	@FXML
    private TableColumn<Produtos, String> pVenda;

    @FXML
    private Button buttomEditar;

    @FXML
    private TableView<Produtos> tabelaConsultarProduto;

    @FXML
    private Button buttomPesquisar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button butomVoltar;

    @FXML
    private TableColumn<Produtos, String> nome;

    @FXML
    private TableColumn<Produtos, String> descricao;

    @FXML
    private TableColumn<Produtos, String> pCompra;

    @FXML
    private Button buttomExcluir;

    @FXML
    private TableColumn<Produtos, String> cod;

    @FXML
    private TableColumn<Produtos, String> outros;

    @FXML
    private TableColumn<Produtos, String> quantidade;

    @FXML
    void pesquisar(ActionEvent event) {
    	produtodados.clear();
		String pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from produtos");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_produto").contains(pesquisa)) {
					produtodados.add(new Produtos(String.valueOf(conecta.rs.getInt("id_produto")),conecta.rs.getString("nome_produto"),
							conecta.rs.getInt("quantidade_produto"), conecta.rs.getFloat("preco_compra"), 
							conecta.rs.getFloat("preco_venda"),conecta.rs.getString("outros_produto"),conecta.rs.getString("descricao_produto")));
	
					cod.setCellValueFactory(new PropertyValueFactory<Produtos, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));
					quantidade.setCellValueFactory(new PropertyValueFactory<Produtos, String>("quantidade"));
					pCompra.setCellValueFactory(new PropertyValueFactory<Produtos, String>("pCompra"));
					pVenda.setCellValueFactory(new PropertyValueFactory<Produtos, String>("pVenda"));
					outros.setCellValueFactory(new PropertyValueFactory<Produtos, String>("outros"));
					descricao.setCellValueFactory(new PropertyValueFactory<Produtos, String>("descricao"));
					tabelaConsultarProduto.setItems(produtodados);
					cont++;
				}
			}if (cont == 0) {
				JOptionPane.showMessageDialog(null,pesquisa + " não encontrado!");
			}			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
		}
    }

    @FXML
    void editar(ActionEvent event) {
    	if (tabelaConsultarProduto.getSelectionModel().getSelectedItem() != null ){
	    	Produtos c = tabelaConsultarProduto.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse produto?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM produtos WHERE id_produto ='"+c.getId()+"'");
	        	txtNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Produto apagado com sucesso");
	        	pesquisar(event);
        	}
    	}
    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

}
