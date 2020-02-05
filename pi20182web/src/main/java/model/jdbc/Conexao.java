/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author thanyla
 */
public class Conexao {

    public static void main(String[] args) {
        //testar se conexão está funcionado
        //System.out.println(criar());

    }

    public static Connection criar(){
        
/*
        try {
            Class.forName("org.postgresql.Driver");
            Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoIntegrador","postgres","senha123");
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  */          
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("ProjetoIntegrador");
            return ds.getConnection();

        } catch (NamingException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return null;
    }
}
