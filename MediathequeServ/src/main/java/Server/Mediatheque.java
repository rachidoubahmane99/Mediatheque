/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
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
    
    public Mediatheque(){
     
        
        
    }
    public static void main(String args[]) throws IOException{
        int port=1000;
        ServerSocket sersoc = new ServerSocket (port) ; 
        System.out.println ("serveur active sur port " + port) ; 
        
        while(true){ 
            Socket soc = sersoc.accept();
            Thread t= new Thread( new ThreadServeur(soc));
            t.start();
        }
    }
    
}
