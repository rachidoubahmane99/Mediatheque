
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import model.Document;
import model.Livre;
import DbConnection.DbConnection;


public class CRUD_Document {
    Connection con = null;
    public Statement stmt;
    
    
    /*public void CRUD_Document() throws SQLException {
   try (Connection con = DbConnection.getConnection();)
        {
             
            System.out.println("Connection sucess");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

}
    */
    boolean ajouterDocument(Document d) throws SQLException{
        if (d instanceof Livre){
                   con = DbConnection.getConnection();
                   stmt = con.createStatement();
         String query="insert into livre(isbn, titre, auteur, edition, editeur,nbpages,url) values ('"+d.getIsbn()+"','"+d.getTitre()+"','"+d.getAuteurs()[0]+"','"+d.getEdition()+"','"+d.getEditeur()+"','"+((Livre)d).getNbPages()+"','"+d.getUrl()+"')";
         //String query="insert into livre(isbn, titre, auteur, edition, editeur,nbpages,url) values ('isbnnn','tiitre de livre','hamid',2019,'hassan',100,'link here')";
         int nbUpdated = stmt.executeUpdate(query);
         return nbUpdated!=0;
        }
        
        else 
            return true;
       
    }
    
    
     LinkedList<Livre> getLivreByTitre(String titre) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
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
     
     
     
     LinkedList<Livre> getLivreByEditeur(String editeurName) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where editeur like '"+editeurName+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
            String titre = rs.getString("titre");
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
     
        LinkedList<Livre> getLivreByAuteur(String auteurName) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where auteur like '"+auteurName+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
            String titre = rs.getString("titre");
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
 con = DbConnection.getConnection();
                   stmt = con.createStatement();
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
           //l.toString();
            //System.out.println(url);
           return l;
       }
        return null;

    }
       
       
       public static void  main(String args[]) throws SQLException{
          CRUD_Document doc = new CRUD_Document();
          String[] auteur={"auteur"}; 
          //First Document
          
       Document d1= new Livre("titre de livre","editeur",2019,"isbn66",auteur,"url",100);
       boolean b;
       Livre  d2;
        //b = doc.ajouterDocument(d1);
          // System.out.println(b);
           
          // d2= doc.getLivreByISBN("isbnnn");
           //System.out.println(d2.toString());
           
           LinkedList<Livre> llist;
           
           llist=doc.getLivreByTitre("tiitre de livre");

    // récupérer le ListIterator
    java.util.ListIterator lIterator = llist.listIterator();
            while(lIterator.hasNext()){
       System.out.println(lIterator.next().toString());
    }
          
           
       }

    
}
