

import DB.*;
import Model.*;
import java.util.*;
public class mediatheque {
    
    CRUD_Client cd;
    CRUD_Document dd;
    CRUD_Kindle dk;
    
    public mediatheque(){
        cd=new CRUD_Client();
        dd=new CRUD_Document();
        dk=new CRUD_Kindle();
    }
    
    //GETTERS DE CLIENT
    public Client getClientById(int idClient){
        return null;
    }
    public ArrayList<Client> getClientByName(String Nom){
        return null;
    }
    
    public ArrayList<Client> getAllClients(){
        return null;
    }
    
    //GETTERS DE DOCUMENT
    public Document getDocumentByISBN(String ISBN){
        return null;
    }
    public ArrayList<Document> getDocumentByTitle(String titre){
        return null;
    }
    
    public ArrayList<Document> getDocumentByEditor(String Editeur){
        return null;
    }
  
    public ArrayList<Document> getDocumentByAnneEdition(int AnneEdition){
        return null;
    }
    public ArrayList<Document> getAllDocuments(){
        return null;
    }
    
    //GETTERS DE KINDLE
    public Kindle getKindleById(int idK){
        return null;
    }
    
    public ArrayList<Kindle> getKindleByModel(String Model){
        return null;
    }
    
    public Kindle getKindleByMac(String Mac){
        return null;
    }
    
    public ArrayList<Kindle> getAllKindles(){
        return null;
    } 
 

    //Client
    public Boolean ajouterClient(){
        //Saisir les informations de client
        //Client c=new Client();
        
        //return cd.ajouterClient(c);
        return false;
    }
    
   /* public Boolean modifierClient(Client c){
        
        return false;
    }*/
    
    public Boolean supprClient(int idClient){
        //return CRUD_Client.supprClient(idClient);
        return false;
        
    }
    //Document
    public Boolean ajouterDocument(Document d){
        //Saisir les informations de Document
        //Document d=new Document();
        
        //return cd.ajouterDocument(d);
        
        return false;
    }
    
    /*public Boolean modifierDocument(Document d){
        return false;
    }*/
    
    public Boolean supprDocument(int idDocument){
        //return CRUD_Document.supprDocument(idDocument);
        return false;
        
    }
    //Kindle
     public Boolean ajouterKindle(Kindle k){
        //Saisir les informations de kindle
        //Kindle k=new Kindle();
        
        //return cd.ajouterKindle(k);
        
        return false;
    }
    
    /*public Boolean modifierKindle(Kindle k){
        return false;
    }*/
    
    public Boolean supprKindle(int idKindle){
        //return CRUD_Kindle.supprKindle(idKindle);
        return false;
        
    }
    
    
    //Gestion des emprunts
    
    public Boolean ajouterEmprunt(Client c,Kindle k){
            //return CRUD_Emprunt.ajouterEmprunt(c,k);
            return false;
    }
    
    public Boolean rendreEmprunt(Emprunt e,Date d){
        //return CRUD_Emprunt.rendreEmprunt(e,d);
        return false;
    }
    
    public ArrayList<Kindle> KindlesNonRendu(){
        //return CRUD_Emprunt.KindlesNonRendu();
        return null;
    }
    
    public ArrayList<Emprunt> getEmpruntEnCour(){
        //return CRUD_Emprunt.getEmpruntEnCour();
        return null;
    }
    
    public Boolean SupprEmprunt(int IdEmprunt){
        //retun CRUD_Emprunt.SupprEmprunt(IdEmprunt);
        return false;
    }
    
    /*
        Gestion des communications avec les kindles
    
    */
    
    //////////////MAIN////////////////////
    public static void main(String []args){
        //afficher le menu au gerant
        //1)Gestion des clients
        //2)Gestion des kindles
        //3)Gestion des documents
    }    
}
