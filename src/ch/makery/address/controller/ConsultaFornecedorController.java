package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Fornecedores;
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

public class ConsultaFornecedorController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	int del;
	private ObservableList<Fornecedores> fornecedordados = FXCollections.observableArrayList();

    @FXML
    private TableView<Fornecedores> tabelaConsultarFornecedor;
    
    @FXML
    private TableColumn<Fornecedores, String> fone;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button buttomEditar;

    @FXML
    private TableColumn<Fornecedores, String> grupo;

    @FXML
    private Button buttomPesquisar;

    @FXML
    private TableColumn<Fornecedores, String> cod;

    @FXML
    private TextField txtNome;

    @FXML
    private Button butomVoltar;

    @FXML
    private TableColumn<Fornecedores, String> nome;

    @FXML
    private TableColumn<Fornecedores, String> cpfCnpj;

    @FXML
    private TableColumn<Fornecedores, String> email;

    @FXML
    void pesquisar(ActionEvent event) {
    	fornecedordados.clear();
		String pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from fornecedores");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_fornecedor").contains(pesquisa)) {
					fornecedordados.add(new Fornecedores(String.valueOf(conecta.rs.getInt("id_fornecedore")),conecta.rs.getString("nome_fornecedor"),
							conecta.rs.getString("cnpj_fornecedor"), conecta.rs.getString("email_fornecedor"),conecta.rs.getString("telefone_fornecedor"),
							conecta.rs.getString("outros_fornecedor")));
	
					cod.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("nome"));
					cpfCnpj.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("cnpj"));
					email.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("email"));
					fone.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("fone"));
					grupo.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("grupo"));
					tabelaConsultarFornecedor.setItems(fornecedordados);
					cont++;
				}
			}if (cont == 0) {
				JOptionPane.showMessageDialog(null,pesquisa + " n�o encontrado!");
			}			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Erro ao mostrar dados"+ex);
		}
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {
    	if (tabelaConsultarFornecedor.getSelectionModel().getSelectedItem() != null ){
	    	Fornecedores c = tabelaConsultarFornecedor.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse Fornecedor?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM fornecedores WHERE id_fornecedor ='"+c.getId()+"'");
	        	txtNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Fornecedor apagado com sucesso");
	        	pesquisar(event);
        	}
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

}