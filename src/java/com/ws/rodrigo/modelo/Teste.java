
package com.ws.rodrigo.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Teste {
    
    public static void main(String [] args){ 
        
        
    //ManterTimesheetFacade    
    
    List<Lancamento> lancamentos = Arrays.asList(new Lancamento(1, "05/05/2020", "Rodrigo"),
            new Lancamento(2, "04/05/2020", "Raquel"),
            new Lancamento(3, "06/05/2020", "Gustavo"),
            new Lancamento(4, "01/05/2020", null),
            new Lancamento(5, "08/05/2020", "Gustavo2"),
            new Lancamento(6, "07/05/2020", "Gustavo25"),
            new Lancamento(7, "01/05/2020", "Gustavo4"));
    
    /*for(Lancamento l : lancamentos){
        System.out.println(l.getData());
    }*/
    
    //lógica
    Set lancSet = new HashSet();
    List<Lancamento> lancRepetido = new ArrayList<>();
    List<Lancamento> lancSemRepetido = new ArrayList<>();
    for(Lancamento l : lancamentos){
          lancSemRepetido.add(l);
    }
     
    for(Lancamento l : lancamentos){
       boolean mudou = lancSet.add(l.getData());
       if(!mudou) {
          lancRepetido.add(l);
          lancSemRepetido.remove(l);
       }
       if(!mudou & l.getUsuario()!=null) {
          System.out.println("SET: " + l.getData());
          System.out.println(l.getUsuario());
       }
    }
    
    //popula lancSetRepetido e remove o repetido de lancSetSemRepetido
    if(!lancRepetido.isEmpty()){
        String data = lancRepetido.get(0).getData();
        lancRepetido = new ArrayList<>();
        
        for (int i = 0; i < lancamentos.size(); i++) {
            if (lancamentos.get(i).getData().equalsIgnoreCase(data)){
                lancRepetido.add(lancamentos.get(i));
                lancSemRepetido.remove(lancamentos.get(i));
            };
        }
    }
    
    for(Lancamento l: lancRepetido) {
        if(l.getUsuario()!= null) {
            lancSemRepetido.add(l);
        }
    }
    
    ////////// Somente impressão na tela
    for(Lancamento l:lancSemRepetido) {
       System.out.println("Lancamentos: "+  l); 
    }
     
    for(Lancamento l:lancRepetido) {
       System.out.println("Repetidos: "+  l); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
}
