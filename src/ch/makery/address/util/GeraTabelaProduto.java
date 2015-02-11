package ch.makery.address.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;


public class GeraTabelaProduto { 
	public static void main(String[] arg) throws Exception {
		
		VerPdfProduto()	;
		
	}	
	public static void VerPdfProduto() throws DocumentException, MalformedURLException, IOException, SQLException{
		ConectaBanco conecta = new ConectaBanco();
				
		
		Document doc = new Document();
		OutputStream os = new FileOutputStream("Produto Relatorio.pdf");
		 PdfWriter.getInstance(doc, os);
		 
		 doc.open();
		 
		 
		 File arquivo = new File("logo.png");

		 System.out.println("logo.png");
		 
		 Image logo = Image.getInstance("C:/Users/Fillipe/workspace/Livraria/src/ch/makery/address/controller/logo.png");
		 logo.scaleToFit(400,200);
		 logo.setAlignment(logo.ALIGN_CENTER);
	                //Alinhamento p/ a esquerda <<<
	    //logo.setAlignment(Image.ALIGN_CENTER);
		 
	    doc.add(logo);
	         
		
		// Definindo uma fonte, com tamanho 20 e negrito
        Font fonte1 = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD);
        Font fonte2 = new Font(FontFamily.COURIER, 14, Font.BOLD);
 
        // Adicionando um parágrafo ao PDF, com a fonte definida acima
        Paragraph p1 = new Paragraph("Obra de Arapiraca", fonte1);
 
        // Setando o alinhamento p/ o centro
        p1.setAlignment(Paragraph.ALIGN_CENTER);
 
        // Definindo
        p1.setSpacingAfter(50);
        doc.add(p1);
        
        Paragraph p2 = new Paragraph("Relatorio de produtos", fonte2);
        
        // Setando o alinhamento p/ o centro
        p2.setAlignment(Paragraph.ALIGN_CENTER);
 
        // Definindo
        p2.setSpacingAfter(10);
        doc.add(p2);
 
        
        // Criando uma tabela com 3 colunas
        //id, nome, preco compra, preco venda, quantidade, outros, descrição
        PdfPTable table = new PdfPTable(7);
        
        // Título para a tabela
        Paragraph id = new Paragraph("ID");
        Paragraph nome = new Paragraph("Nome");
        Paragraph pCompra = new Paragraph("Preço de compra");
        Paragraph pVenda = new Paragraph("Preço de venda");
        Paragraph quantidades = new Paragraph("Quantidades");
        Paragraph outros = new Paragraph("Outros");
        Paragraph descricao = new Paragraph("Descrição");
        
        
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
        	try {
				list.add(conecta.rs.getString("id_produto"));
				list.add(conecta.rs.getString("nome_produto"));
	        	list.add(conecta.rs.getString("preco_compra"));
	        	list.add(conecta.rs.getString("preco_venda"));
	        	list.add(conecta.rs.getString("quantidade_produto"));
	        	list.add(conecta.rs.getString("outros_produto"));
	        	list.add(conecta.rs.getString("descricao_produto"));
        	}
        	 catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
        }
 
        for (String s : list) {
            table.addCell(s);
        }
 
        doc.add(table);
 
        doc.close();
        }
        }

}