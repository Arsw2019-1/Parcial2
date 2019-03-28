/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arswparcial2.demo.connection;

/**
 *
 * @author 2098325
 */
import com.arswparcial2.demo.connection.connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author dicom
 */
@Service
public class HttpConnection extends Thread{
    //API key 
    @Autowired
    private Provider pv;
    private static final String USER_AGENT = "Mozilla/5.0";
    private String url;
    private String result;

    public String getResult() throws IOException {
        return result;
    }
    
    @Override
    public void run(){
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            StringBuffer response = new StringBuffer();
            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("GET request not worked");
            }       
            System.out.println("GET DONE");
            System.out.println(response.toString());
            result= response.toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect(String nombreCiudad) {
        url=pv.getClima(nombreCiudad);
    }


}