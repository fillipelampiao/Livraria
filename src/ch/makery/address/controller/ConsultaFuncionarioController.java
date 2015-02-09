package ch.makery.address.controller;

import javax.swing.JOptionPane;

import ch.makery.address.Main;
import ch.makery.address.model.Funcionarios;
import ch.makery.address.util.ConectaBanco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultaFuncionarioController {
	ConectaBanco conecta = new ConectaBanco();
	Main main = new Main();
	int del;
	private ObservableList<Funcionarios> funcionariodados = FXCollections.observableArrayList();

	 @FXML
	    private Button buttomEditar;

	    @FXML
	    private TableColumn<Funcionarios, String> grupo;

	    @FXML
	    private Button buttomPesquisar;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private Button butomVoltar;

	    @FXML
	    private TableColumn<Funcionarios, String> nome;

	    @FXML
	    private TableView<Funcionarios> tabelaConsultarFuncionario;

	    @FXML
	    private TableColumn<Funcionarios, String> senha;

	    @FXML
	    private TableColumn<Funcionarios, String> rg;

	    @FXML
	    private Button buttomExcluir;

	    @FXML
	    private TableColumn<Funcionarios, String> cpf;

	    @FXML
	    private TableColumn<Funcionarios, String> cod;

	    @FXML
	    private TableColumn<Funcionarios, String> outros;

	    @FXML
	    private TableColumn<Funcionarios, String> email;

    @FXML
    void pesquisar(ActionEvent event) {
    	funcionariodados.clear();
		String pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from funcionarios");
			int cont = 0 ;
			while(conecta.rs.next()){
				if (conecta.rs.getString("nome_funcionario").contains(pesquisa)) {
					funcionariodados.add(new Funcionarios(String.valueOf(conecta.rs.getInt("id_funcionario")),conecta.rs.getString("nome_funcionario"),
							conecta.rs.getString("cpf_funcionario"), conecta.rs.getString("rg_funcionario"), 
							conecta.rs.getString("email_funcionario"),conecta.rs.getString("outros_funcionario"),conecta.rs.getString("id_grupo"),conecta.rs.getString("senha_funcionario")));
	
					cod.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("id"));
					nome.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("nome"));
					senha.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("senha"));
					cpf.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("cpf"));
					rg.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("rg"));
					email.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("email"));
					grupo.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("grupo"));
					tabelaConsultarFuncionario.setItems(funcionariodados);
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

    }

    @FXML
    void excluir(ActionEvent event) {
    	if (tabelaConsultarFuncionario.getSelectionModel().getSelectedItem() != null ){
	    	Funcionarios c = tabelaConsultarFuncionario.getSelectionModel().getSelectedItem();
	    	del = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse funcionário?");
    	
	    	if (del == JOptionPane.YES_OPTION){
	        	conecta.executaSQL("DELETE FROM funcionarios WHERE id_funcionario ='"+c.getId()+"'");
	        	txtNome.setText("");
	        	JOptionPane.showMessageDialog(null,"Funcionário apagado com sucesso");
	        	pesquisar(event);
        	}
    	}
    }

    @FXML
    void voltar(ActionEvent event) {
    	main.iniciaTelas("view/Consulta.fxml");
    }

}
