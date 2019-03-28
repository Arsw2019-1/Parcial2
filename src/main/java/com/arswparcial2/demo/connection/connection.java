/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arswparcial2.demo.connection;

import java.io.IOException;

/**
 *
 * @author 2098325
 */
public interface connection {
        public String getResult()throws IOException;
    public void connect(String frecuencia, String compania);
}
