
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Client;
import model.Etudiant;
import model.Professeur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class CRUD_Client {
     Connection con = null;
    public Statement stmt;
    
    boolean Ajouter(Client c){
        //.......
        return true;
    }
    
    boolean Modifier(Client c){
        //.......
        return true;
    }
    
    boolean supprimer(Client c){
        //.......
        return true;
    }
    
    boolean getclient( String cin){
        //.......
        return true;
    }
      public  boolean verefierCompteEtudiant(String cin,String mdp) throws SQLException {
     con = DbConnection.getConnection();
                   stmt = con.createStatement();

         //String sql = "SELECT * FROM personne Where cin = ? and password = ?";
         
         String query="select * from etudiant where  cin='"+cin+"' and password= '"+mdp+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        //LinkedList<Livre> livres= new   LinkedList<Livre> ();
       
            try {
               
                if (!rs.next()) {
                  System.out.println("failed");
                  return false;
                } else {
                  System.out.println("succesfully connected");
                  return true ;
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        return true; 
    }
      
      
      public Etudiant getEtudiantByCne(String cne) throws SQLException{
          con = DbConnection.getConnection();
                   stmt = con.createStatement();

         //String sql = "SELECT * FROM personne Where cin = ? and password = ?";
         
         String query="select * from etudiant where  cne='"+cne+"' ";
        ResultSet rs=stmt.executeQuery(query);
        Etudiant e =null;
          if (rs.next()) {
              String login = rs.getString("logn");
            String mdp = rs.getString("password");
            String cin = rs.getString("cin");
           String nom=rs.getString("nom");
           String prenom=rs.getString("prenom");
           String Cne=rs.getString("cne");
  
            e = new Etudiant(login, mdp, cin, nom, prenom,Cne);
          }
          return e;
      }
    
      public Professeur getProfesseurByCin(String cin) throws SQLException{
          con = DbConnection.getConnection();
                   stmt = con.createStatement();

         //String sql = "SELECT * FROM personne Where cin = ? and password = ?";
         
         String query="select * from professeur where  cin='"+cin+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        Professeur p =null;
          if (rs.next()) {
              String login = rs.getString("login");
            String mdp = rs.getString("password");
            String Cin = rs.getString("cin");
           String nom=rs.getString("nom");
           String prenom=rs.getString("prenom");
           String matricule=rs.getString("matricule");
  
            p = new Professeur(login, prenom, Cin, nom, prenom, matricule);
          }
          return p;
      }
      
      
      
       boolean SupprimerEtudiant(String cne) throws SQLException{
         con = DbConnection.getConnection();
         stmt = con.createStatement();
        String sql = "delete from etudiant where cne='"+cne+"'";
        int etat =stmt.executeUpdate(sql);
        if (etat ==1) {
            return  true;
        }
        return false;
    }
       
       boolean SupprimerProfesseur(String cin) throws SQLException{
         con = DbConnection.getConnection();
         stmt = con.createStatement();
        String sql = "delete from professeur where cne='"+cin+"'";
        int etat =stmt.executeUpdate(sql);
        if (etat ==1) {
            return  true;
        }
        return false;
    }
      
}
    
    
