package ch.makery.address.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectaBanco {
	public Statement stm;	//realizar pesquisas
	public ResultSet rs;	//armazenar pesquisas
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5432/livraria";
	private String usuario = "postgres";
	private String senha = "hl9255";
	public Connection conn;	//conex�o com o banco de dados
	
	public void conexao(){	//m�todo respons�vel por realizar a conex�o com o banco
		try {
			System.setProperty("jdbc.Drivers", driver); //seta a propriedade do driver de conx�o
			conn = DriverManager.getConnection(caminho, usuario, senha); //realiza a conex�o com o banco de dados
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de conex�o!"+ ex.getMessage());
		}
	}
	
	public void executaSQL(String sql){
		try {
			stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {}
	}
	public void desconecta(){	//m�todo para fechar a conex�o com bd
		try {
			conn.close();	//fecha a conex�o
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao fechar conex�o" + ex.getMessage());
		}
	}
}
