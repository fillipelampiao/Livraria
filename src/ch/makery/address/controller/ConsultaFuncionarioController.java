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
import javafx.stage.Stage;

public class ConsultaFuncionarioController {
	ConectaBanco conecta = new ConectaBanco();
	VerProdutoCadastro telaeditar = new VerProdutoCadastro();
	Main main = new Main();
	int del;
	static String idfunc;
	static String pesquisa;
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
		pesquisa = txtNome.getText();
		try {
			conecta.conexao();
			conecta.executaSQL("select * from funcionarios");
			int cont = 0 ;
			while(conecta.rs.next()){
				//(String id,String nome,String cpf,String rg,String email,String outros,String identificacao
				if (conecta.rs.getString("nome_funcionario").contains(pesquisa)) {
					funcionariodados.add(new Funcionarios(String.valueOf(conecta.rs.getInt("id_funcionario")),conecta.rs.getString("nome_funcionario")
							,conecta.rs.getString("cpf_funcionario"), conecta.rs.getString("rg_funcionario"), 
							conecta.rs.getString("email_funcionario"),conecta.rs.getString("outros_funcionario"),conecta.rs.getString("senha_funcionario")));
	
					email.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("fone"));
					cod.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("nome"));
					senha.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("identificacao"));
					nome.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("cpf"));
					cpf.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("rg"));
					rg.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("email"));
					outros.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>("outros"));
					grupo.setCellValueFactory(new PropertyValueFactory<Funcionarios, String>(""));
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
    	if (tabelaConsultarFuncionario.getSelectionModel().getSelectedItem() != null ){
	    	Funcionarios novo = tabelaConsultarFuncionario.getSelectionModel().getSelectedItem();
	    	idfunc = novo.getNome();
	    	conecta.conexao();
	    	conecta.executaSQL("select * from funcionarios where id_funionario='"+novo.getNome()+"'");
	    	new VerProdutoCadastro().start(new Stage()); 
	    	telaeditar.iniciarTelaDois("view/EditarConsultaFuncionario.fxml");
    	}
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
