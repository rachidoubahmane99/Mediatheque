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
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import model.Document;
import model.Emprunt;

/**
 *
 * @author rachid dev
 */
public class Mediatheque implements Serializable{
     Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    LinkedList<Document> documents;
    //LinkedList<Personne> emprunteurs;
    LinkedList<Emprunt> emprunts;
    static int instanceCounter = 0;

    public int counter = 0;

   
    public Mediatheque(){
     
        instanceCounter++;
        counter = instanceCounter;
        
    }
    static String type;
     static String login;
     String message= null;
    static String mdp;
    public static void main(String args[]) throws IOException{
        int port=1000;
        ServerSocket sersoc = new ServerSocket (port) ; 
        System.out.println ("serveur active sur port " + port) ; 
        OutputStream flux1 = null ;
        
        while(true){ 
            Socket soc = sersoc.accept();
            Mediatheque md = new Mediatheque();
            //System.out.println("Server instance "+md.counter);
            String IotMaps = "KindleGps"+md.counter;
            System.out.println("IotMaps :"+IotMaps+" : connected");
            flux1 = soc.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter (flux1) ;
            InputStream flux2=soc.getInputStream();
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux2));
            
            type=entree.readLine();
            sortie.flush();
            login=entree.readLine();
             System.out.println(type+": "+login+" ") ;
             sortie.flush();
            mdp=entree.readLine();
             System.out.println(type+": "+login+" :"+mdp) ;
            Thread t= new Thread( new ThreadServeur(soc,login,type));
            t.start();
        }
    }
    
}
