/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BD.Query;
import Model.Client;

/**
 *
 * @author leonl
 */
public class ClientDao {
    public void addClient(Client client){
        String sql="insert into client values(null,?,?,?,?,?,?)";
        Query.afferentSQL(sql);
        Query.parameter.add(0,"sss");
        
    }
}
