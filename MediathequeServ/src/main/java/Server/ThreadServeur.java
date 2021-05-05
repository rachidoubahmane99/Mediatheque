/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;
import model.Professeur;
import model.Utilisateur;

/**
 *
 * @author rachid dev
 */
public class ThreadServeur implements Runnable{

    Socket soc;
    static boolean repeat=true;
     String nickname;
      String login;
     String message= null;
    static String mdp;
    public ThreadServeur(Socket soc, String type, String login) {
         this.soc=soc;
           this.nickname = type;
         this.login= login;
       
    }
    
    
    

    @Override
      public void run() {
        
        OutputStream flux1 = null ;
        try {
            flux1 = soc.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter (flux1) ;
            InputStream flux2=soc.getInputStream();
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux2));
            /*
            nickname=entree.readLine();
            sortie.flush();
            login=entree.readLine();
             System.out.println(nickname+": "+login+" ") ;
             sortie.flush();
            mdp=entree.readLine();
             System.out.println(nickname+": "+login+" :"+mdp) ;
*/
            while (repeat){
           
                 String location=(entree.readLine());
                 
                System.out.println(nickname+": "+login+" : location :"+location) ;
          
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadServeur.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                flux1.close();
            } catch (IOException ex) {
                Logger.getLogger(ThreadServeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
     } 

        
    
    

    
}
