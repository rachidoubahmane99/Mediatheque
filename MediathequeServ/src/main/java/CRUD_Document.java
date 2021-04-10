
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import model.Document;
import model.Livre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rachad
 */
public class CRUD_Document {
    
    Statement stmt;
    
    public void CRUD_Document(String username, String password) throws SQLException {
    
    Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/mediatheque",
                         username,
                         password);
   
    stmt = con.createStatement();

}
    
    boolean ajouterDocument(Document d) throws SQLException{
        if (d instanceof Livre){
         String query="insert into livre(isbn, titre, auteur, edition, editeur,nbpages,url) values ('"+d.getIsbn()+"','"+d.getTitre()+"','"+d.getAuteurs()[0]+"','"+d.getEdition()+"','"+d.getEditeur()+"','"+((Livre)d).getNbPages()+"','"+d.getUrl()+"')";
         int nbUpdated = stmt.executeUpdate(query);
         return nbUpdated!=0;
        }
        
        else 
            return true;
       
    }
    
    
     LinkedList<Livre> getLivreByTitre(String titre) throws SQLException{

        String query="select * from livre where titre like '"+titre+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           livres.add(l);
       }

       return livres;
    }
     
       Livre getLivreByISBN(String isbn) throws SQLException{

        String query="select * from livre where isbn like'"+isbn+"' ";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           return l;
       }
        return null;

    }
       

    
}
