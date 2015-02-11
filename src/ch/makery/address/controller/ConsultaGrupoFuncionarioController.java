package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Grupos;
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

public class ConsultaGrupoFuncionarioController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	private ObservableList<Grupos> grupodados = FXCollections.observableArrayList();
	VerProdutoCadastro telaeditar = new VerProdutoCadastro();
	static String idGrupo;

    @FXML
    private TableView<Grupos> tabelaGrupoFuncionario;
    
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
			conecta.executaSQL("select * from grupos where tipo_grupo=2");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_grupo").contains(pesquisa)) {
					grupodados.add(new Grupos(String.valueOf(conecta.rs.getInt("id_grupo")),conecta.rs.getString("nome_grupo")));	
					cod.setCellValueFactory(new PropertyValueFactory<Grupos, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Grupos, String>("nome"));
					tabelaGrupoFuncionario.setItems(grupodados);
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
    	if (tabelaGrupoFuncionario.getSelectionModel().getSelectedItem() != null ){
	    	Grupos novo = tabelaGrupoFuncionario.getSelectionModel().getSelectedItem();
	    	idGrupo = novo.getId();
	    	conecta.conexao();
	    	conecta.executaSQL("select * from grupos_funcionarios where id_funcionario='"+novo.getId()+"'");
    	new VerProdutoCadastro().start(new Stage()); 
    	telaeditar.iniciarTelaDois("view/EditarConsultaGrupoFuncionario.fxml");
    	}
    }

    @FXML
    void excluir(ActionEvent event) {
    	if (tabelaGrupoFuncionario.getSelectionModel().getSelectedItem() != null ){
	    	Grupos c = tabelaGrupoFuncionario.getSelectionModel().getSelectedItem();
	    	int del;
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse grupo?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM grupos WHERE id_grupo ='"+c.getId()+"'");
	        	conecta.executaSQL("DELETE FROM grupos_funcionarios WHERE id_grupo ='"+c.getNome()+"'");
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
