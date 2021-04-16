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
    static String nickname;
    
    public ThreadServeur(Socket soc) {
         this.soc=soc;
    }
    
    
    

    @Override
      public void run() {
        
        OutputStream flux1 = null ;
        try {
            flux1 = soc.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter (flux1) ;
            InputStream flux2=soc.getInputStream();
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux2));
            
            nickname=entree.readLine();
 
            while (repeat){
                String message=entree.readLine();
                System.out.println(nickname+": "+message) ;
                 String location=(entree.readLine());
                 
                System.out.println(nickname+": "+message) ;
                switch (message){
                    case "Tell":
                        //tell(entree,sortie);
                        System.out.println("Tell choised)");
                        break;
                    case "Learn":
                        //learn(entree,sortie);
                          System.out.println("Learn choised)");
                        break;
                    case "Quit":
                        //quit(entree,sortie);
                          System.out.println("leave choised)");
                        soc.close();
                }
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
