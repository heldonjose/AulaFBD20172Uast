/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.util;

/**
 *
 * @author prof Heldon
 */
public class Util {
    
     
    public static String removerCaracteresEspeciais(String valor){
        return valor.replaceAll("[.-]", "");
    }
    
}
