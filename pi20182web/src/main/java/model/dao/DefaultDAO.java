
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.jdbc.Conexao;
import model.rota.Default;


public class DefaultDAO {
    public boolean inserir(Default d){
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String insertSql = "insert into rotadefault (gateway, identificador) values (?, 21)";
        
        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, d.getGateway());
            
            if(ps.executeUpdate() !=  0){
                
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefaultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (con != null) {

            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }
    
        public boolean update(Default d) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update rotadefault set identificador = 22 where iddefault = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, d.getId());

            if (ps.executeUpdate() == 1) {

                con.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (con == null) {
            return false;
        }

        return false;
    }
    
    public boolean deletar(Default d){
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String deleteSql = "delete from rotadefault where iddefault = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, d.getId());
            
            if(ps.executeUpdate() == 1){
                
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefaultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (con != null) {

            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public ArrayList<Default> buscarRedes() {
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from rotadefault";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Default> defaults = new ArrayList();

            while (rs.next()) {
                
                Default rotadefault = new Default();
                rotadefault.setId(rs.getInt("iddefault"));
                rotadefault.setGateway(rs.getString("gateway"));
               
                defaults.add(rotadefault);
            }
            con.close();
            
            return defaults;
        } catch (SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {

            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public Default buscarRedes(int id){
        
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from rotadefault where iddefault = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                Default d = new Default();
                d.setGateway(rs.getString("gateway"));
                d.setId(rs.getInt("iddefault"));
                
                con.close();
                return d;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DefaultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (con != null) {

            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}


