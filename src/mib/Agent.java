/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import oru.inf.InfDB;

/**
 *
 * @author Daniel
 */
public class Agent {
    
    private final InfDB idb;
    private String id;
    
    public Agent(InfDB idb, String id){
        
        this.idb = idb;
        this.id = id;
        
    }
}
