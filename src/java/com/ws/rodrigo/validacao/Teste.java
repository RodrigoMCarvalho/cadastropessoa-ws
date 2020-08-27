/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.rodrigo.validacao;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author rodri_000
 */
public class Teste {
    
    public static void main(String[] args) {
        String cnpj = "12345678912345";
        System.out.println(formatarCnpj(cnpj));
    }
    
    public static String formatarCnpj(String cnpj) {
        try {
                MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
                mask.setValueContainsLiteralCharacters(false);
                return mask.valueToString(cnpj);
        } catch(ParseException e) {
                return cnpj;
        }
    }
}
