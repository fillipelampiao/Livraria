package ch.makery.address.util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class GeraTabelaProduto { 
	
	
	public void chamaCaminho(){
		File pdf = new File("Produto_Relatorio.pdf");  
		try {  
		  Desktop.getDesktop().open(pdf);  
		} catch(Exception ex) {  
		  ex.printStackTrace();  
		  JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
		}  }
	
	
	public static void geraPdf() throws DocumentException, SQLException, MalformedURLException, IOException{		
		
		ConectaBanco conecta = new ConectaBanco();
		
		
		
		 Document doc = new Document(PageSize.A4, 30, 10, 10, 10);
		OutputStream os = new FileOutputStream("Produto_Relatorio.pdf");
		 PdfWriter.getInstance(doc, os);
		 
		 doc.open();
		 
		 
		 File arquivo = new File("logo.png");

		 
		 
		 Image logo = Image.getInstance("imgsUteis/logo.png");
		 logo.scaleToFit(400,200);
		 logo.setAlignment(logo.ALIGN_CENTER);
	    //logo.setAlignment(Image.ALIGN_CENTER);
	 
	    doc.add(logo);
	         
		
		// Definindo uma fonte, com tamanho 20 e negrito
        Font fonte1 = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD);
        Font fonte2 = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
        Font fonte3 = new Font(FontFamily.COURIER, 12);
        Font fonte4 = new Font(FontFamily.COURIER, 12);
                
        // Adicionando um parágrafo ao PDF, com a fonte definida acima
        Paragraph p1 = new Paragraph("Obra de Arapiraca", fonte1);
 
        // Setando o alinhamento p/ o centro
        p1.setAlignment(Paragraph.ALIGN_CENTER);
 
        // Definindo
        p1.setSpacingAfter(50);
        doc.add(p1);
        
        Paragraph p2 = new Paragraph("Relatório de Produtos", fonte2);
        
        // Setando o alinhamento p/ o centro
        p2.setAlignment(Paragraph.ALIGN_CENTER);
 
        // Definindo
        p2.setSpacingAfter(10);
        doc.add(p2);
        
        
        
        // Criando uma tabela com 3 colunas
        //id, nome, preco compra, preco venda, quantidade, outros, descrição
        PdfPTable table = new PdfPTable(new float[] {0.2f,0.4f,0.4f,0.3f,0.5f,0.5f,0.5f});
        // Título para a tabela
        
        table.setWidthPercentage(100.0f); // tamanho da tablea
        
        Paragraph id = new Paragraph("ID",fonte3);
        Paragraph nome = new Paragraph("Nome",fonte3);
        Paragraph pCompra = new Paragraph("P. de compra",fonte3);
        Paragraph pVenda = new Paragraph("P. de venda",fonte3);
        Paragraph quantidades = new Paragraph("Quantidades",fonte3);
        Paragraph outros = new Paragraph("Outros",fonte3);
        Paragraph descricao = new Paragraph("Descrição",fonte3);
        
        
        PdfPCell id1 = new PdfPCell(id);
        PdfPCell nome1 = new PdfPCell(nome);
        PdfPCell pCompra1 = new PdfPCell(pCompra);
        PdfPCell pVenda1 = new PdfPCell(pVenda);
        PdfPCell quantidades1 = new PdfPCell(quantidades);
        PdfPCell outros1 = new PdfPCell(outros);
        PdfPCell descricao1 = new PdfPCell(descricao);
        
        id1.setColspan(1);
        nome1.setColspan(1);
        pCompra1.setColspan(1);
        pVenda1.setColspan(1);
        quantidades1.setColspan(1);
        outros1.setColspan(1);
        descricao1.setColspan(1);
        
        id1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        nome1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        pCompra1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        pVenda1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        quantidades1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        outros1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        descricao1.setHorizontalAlignment(Paragraph.ALIGN_CENTER);
        // Adicionando o header à tabela
        table.addCell(id1);
        table.addCell(nome1);
        table.addCell(pCompra1);
        table.addCell(pVenda1);
        table.addCell(quantidades1);
        table.addCell(outros1);
        table.addCell(descricao1);
 
        
		conecta.conexao();
		conecta.executaSQL("select * from produtos");
		
        ArrayList<String> list = new ArrayList<String>();
        while(conecta.rs.next()) {
        	list.add(conecta.rs.getString("id_produto"));
        	list.add(conecta.rs.getString("nome_produto"));
        	list.add(conecta.rs.getString("preco_compra"));
        	list.add(conecta.rs.getString("preco_venda"));
        	list.add(conecta.rs.getString("quantidade_produto"));
        	list.add(conecta.rs.getString("outros_produto"));
        	list.add(conecta.rs.getString("descricao_produto"));
        }
 
        for (String s : list) {
            table.addCell(s);
        }
 
        doc.add(table);
 
        doc.close();
        
		}
	}


