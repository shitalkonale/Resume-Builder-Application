/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF_Generate_dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String file_name="E:\\PDF_Generater\\Resume2.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			
			DBConnection obconnection = new DBConnection();
			Connection connection = obconnection.getConnection();	
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String query="SELECT * FROM resume";
			ps=connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
                                
				Paragraph para = new Paragraph("Full Name: Mrs "+rs.getString("first")+"  "+rs.getString("middle")+"  "
                                        +rs.getString("last")+" \n "+rs.getString("date")+"  "+rs.getString("email")+"  "+rs.getString("male")
                                        +rs.getString("female")+"  "+rs.getString("phone")+"  "+rs.getString("city")+"  "+rs.getString("address")
                                        +"  "+rs.getString("college")+"  "+rs.getString("branch")+"  "+rs.getString("education")+"  "+rs.getString("cgpa")+rs.getString("edustart")+rs.getString("eduend")+rs.getString("project")
                                        +"  "+rs.getString("prostart")+rs.getString("proend")+rs.getString("proinfo")
                                        +"  "+rs.getString("techskill")+rs.getString("acco"));
                                        
				document.add(para);
				document.add(new Paragraph("    "));
			}
			document.close();
			System.out.println("finish");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
