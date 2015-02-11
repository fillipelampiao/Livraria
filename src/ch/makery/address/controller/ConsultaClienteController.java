package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.model.Cliente;
import ch.makery.address.model.Funcionarios;
import ch.makery.address.Main;
import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.VerProdutoCadastro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ConsultaClienteController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	int del;
	private ObservableList<Cliente> clientedados = FXCollections.observableArrayList();
	VerProdutoCadastro telaeditar = new VerProdutoCadastro();
	static String idcliente;

    @FXML
    private TableView<Cliente> tabelaConsultarCliente;
    
    @FXML
    private TableColumn<Cliente, String> fone;

    @FXML
    private TableColumn<Cliente, String> rg;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button buttomEditar;

    @FXML
    private TableColumn<Cliente, String> cpf;

    @FXML
    private TableColumn<Cliente, String> grupo;

    @FXML
    private Button buttomPesquisar;

    @FXML
    private TableColumn<Cliente, String> cod;

    @FXML
    private TextField txtNome;

    @FXML
    private Button butomVoltar;

    @FXML
    private TableColumn<Cliente, String> nome;

    @FXML
    private TableColumn<Cliente, String> email;

    @FXML
    void pesquisar(ActionEvent event) {
    	clientedados.clear();
		String pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from clientes");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_cliente").contains(pesquisa)) {
					clientedados.add(new Cliente(String.valueOf(conecta.rs.getInt("id_cliente")),conecta.rs.getString("nome_cliente"),
							conecta.rs.getString("cpf_cliente"), conecta.rs.getString("rg_cliente"), 
							conecta.rs.getString("email_cliente"),conecta.rs.getString("telefone_cliente"),conecta.rs.getString("id_grupo")));
	
					cod.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
					cpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
					rg.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rg"));
					email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
					fone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("fone"));
					grupo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("grupo"));
					tabelaConsultarCliente.setItems(clientedados);
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
    	if (tabelaConsultarCliente.getSelectionModel().getSelectedItem() != null ){
	    	Cliente novo = tabelaConsultarCliente.getSelectionModel().getSelectedItem();
	    	idcliente = novo.getId();
	    	conecta.conexao();
	    	conecta.executaSQL("select * from clientes where id_cliente='"+novo.getId()+"'");
    	new VerProdutoCadastro().start(new Stage()); 
    	telaeditar.iniciarTelaDois("view/EditarConsultaCliente.fxml");
    	}
    }

    @FXML
    void excluir(ActionEvent event) {
    	if (tabelaConsultarCliente.getSelectionModel().getSelectedItem() != null ){
	    	Cliente c = tabelaConsultarCliente.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse cliente?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM clientes WHERE id_cliente ='"+c.getId()+"'");
	        	txtNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Cliente apagado com sucesso");
	        	pesquisar(event);
        	}
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

}
