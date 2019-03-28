/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arswparcial2.demo.services;

/**
 *
 * @author 2098325
 */
import com.arswparcial2.demo.connection.HttpConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServicesClima implements serviClima{

        @Autowired
    HttpConnection conection;
    
    
    @Override
    public String consulCity(String ciudad) {
        String resp="";
        conection.run();
        conection.connect(ciudad);
            try {
                resp=conection.getResult();
            } catch (IOException ex) {
                Logger.getLogger(ServicesClima.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("que imprime de respuesta : "+resp);
        return resp;
          
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
