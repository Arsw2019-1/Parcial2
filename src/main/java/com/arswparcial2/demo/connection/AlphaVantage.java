/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arswparcial2.demo.connection;

import javax.xml.ws.Provider;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2098325
 */
@Service
public class AlphaVantage implements Providerr{
    @Override
    public String getClima(String nombreCiudad) {
        //http://api.openweathermap.org/data/2.5/weather?q=Cali&appid=80c9ba49cb19fed4e056de5cf6710290
        
            String r="http://api.openweathermap.org/data/2.5/weather?q="+nombreCiudad+"&appid=80c9ba49cb19fed4e056de5cf6710290"; 
            System.out.println("miremos q nos trae pitas"+r);
        return r;
    }


}