package ch.makery.address.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ch.makery.address.util.ConectaBanco;
import ch.makery.address.util.VerProdutoCadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarConsultaGrupoFornecedorController implements Initializable{
	static String idgrupo;
	VerProdutoCadastro novaTela = new VerProdutoCadastro();
	ConsultaGrupoFornecedorController grupoDados = new ConsultaGrupoFornecedorController();
	ConectaBanco conecta = new ConectaBanco();
	static String pesquisa;

    @FXML
    private Button butomVoltar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button buttomConfirmar;

    @FXML
    void confirmar(ActionEvent event) {
		idgrupo = ConsultaGrupoFornecedorController.idGrupo;
		int id = Integer.valueOf(idgrupo);
    	conecta.conexao();
		try {
			PreparedStatement pst = conecta.conn.prepareStatement("update grupos set nome_grupo='"+txtNome.getText()+"' where id_grupo='"+id+"'");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	novaTela.stage2.close();
    }

    @FXML
    void voltar(ActionEvent event) {
    	novaTela.stage2.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idgrupo = ConsultaGrupoFornecedorController.idGrupo;
		int id = Integer.valueOf(idgrupo);
		conecta.conexao();
		conecta.executaSQL("select * from grupos, grupos_fornecedores where grupos.tipo_grupo=grupos_fornecedores.id_grupo_fornecedor");
	
		try {
			while (conecta.rs.next()) {
				txtNome.setText(conecta.rs.getString("nome_grupo"));
//				txtGrupo.setText(conecta.rs.getString("grupo_funcionario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
