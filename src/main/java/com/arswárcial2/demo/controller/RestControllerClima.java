/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arswárcial2.demo.controller;
import com.arswparcial2.demo.services.serviClima;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;

/**
 *
 * @author 2098325
 */

@RestController

@RequestMapping(value = "/clima")
public class RestControllerClima {



    Map<String, String> cache = new HashMap<String, String>();
    
    @Autowired
    serviClima rt;
    
    
    
    @RequestMapping(method = RequestMethod.GET,value="/cl/{ciudad}")
    public ResponseEntity<?> getConsultCity(@PathVariable("ciudad") String ciudad){
        try{

            
            if(cache.containsKey(ciudad)){
                //return new ResponseEntity<>(empresas.get(compania),HttpStatus.ACCEPTED);
                return new ResponseEntity<>(cache.containsValue(ciudad),HttpStatus.ACCEPTED);
            }else{
                //base.almacenar(compania,infoServices.getAcciones(frecuencia, compania));
                String g=rt.consulCity(ciudad);
                cache.put(ciudad,g);
                //empresas.put(compania,);
                return new ResponseEntity<>(g,HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            Logger.getLogger(RestControllerClima.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}
