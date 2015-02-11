package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Funcionarios;
import ch.makery.address.model.Grupos;
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
import javafx.stage.Stage;

public class ConsultaGrupoClienteController {
	
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	private ObservableList<Grupos> grupodados = FXCollections.observableArrayList();
	VerProdutoCadastro telaeditar = new VerProdutoCadastro();
	static String idGrupo;
	
    @FXML
    private TableView<Grupos> tabelaGrupoCliente;

    @FXML
    private Button buttomExcluir;

    @FXML
    private Button buttomEditar;

    @FXML
    private Button buttomPesquisar;

    @FXML
    private TableColumn<Grupos, String> cod;

    @FXML
    private TextField txtNome;

    @FXML
    private Button butomVoltar;

    @FXML
    private TableColumn<Grupos, String> nome;

    @FXML
    void pesquisar(ActionEvent event) {
    	grupodados.clear();
		String pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from grupos where tipo_grupo=1");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_grupo").contains(pesquisa)) {
					grupodados.add(new Grupos(String.valueOf(conecta.rs.getInt("id_grupo")),conecta.rs.getString("nome_grupo")));	
					cod.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
					tabelaGrupoCliente.setItems(grupodados);
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
    	if (tabelaGrupoCliente.getSelectionModel().getSelectedItem() != null ){
	    	Grupos novo = tabelaGrupoCliente.getSelectionModel().getSelectedItem();
	    	idGrupo = novo.getId();
	    	conecta.conexao();
	    	conecta.executaSQL("select * from grupos_clientes where id_funionario='"+novo.getId()+"'");
    	new VerProdutoCadastro().start(new Stage()); 
    	telaeditar.iniciarTelaDois("view/EditarConsultaGrupoCliente.fxml");
    	}
    }

    @FXML
    void excluir(ActionEvent event) {
    	if (tabelaGrupoCliente.getSelectionModel().getSelectedItem() != null ){
	    	Grupos c = tabelaGrupoCliente.getSelectionModel().getSelectedItem();
	    	int del;
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse grupo?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM grupos WHERE id_grupo ='"+c.getId()+"'");
	        	conecta.executaSQL("DELETE FROM grupos_clientes WHERE id_grupo ='"+c.getId()+"'");
	        	txtNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Grupo apagado com sucesso");
	        	pesquisar(event);
        	}
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

}
