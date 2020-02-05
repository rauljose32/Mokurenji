package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.interfaces.Interface;
import model.jdbc.Conexao;

public class InterfaceDAO {

    public boolean inserir(Interface i) {
        Connection con = Conexao.criar();
        if (con == null) {
            return false;
        }
        String insertSql = "insert into interface (nome, ip, mascara, identificador) values (?, ?, ?, 11);";

        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, i.getNome());
            ps.setString(2, i.getIp());
            ps.setString(3, i.getMascara());

            if (ps.executeUpdate() != 0) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public boolean update(Interface i) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update interface set identificador = 12 where idinterface = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, i.getId());

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

    public boolean deletar(Interface i) {
        Connection con = Conexao.criar();
        if (con == null) {
            return false;
        }
        String deleteSql = "delete from interface where idinterface = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, i.getId());
            
            if(ps.executeUpdate() == 1){
                 con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public List<Interface> buscarInterfaces(){
        
        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from interface";
        
        try {
            PreparedStatement ps = con.prepareStatement(selectSql);
            
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Interface> interfaces = new ArrayList();
            
            while(rs.next()){
                
                Interface i = new Interface();
                
                i.setId(rs.getInt("idinterface"));
                i.setIp(rs.getString("ip"));
                i.setMascara(rs.getString("mascara"));
                i.setNome(rs.getString("nome"));
                
                interfaces.add(i);
                
            }
            con.close();
            return interfaces;
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Interface buscarInterfaces(int id){
        
        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from interface where idinterface = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                Interface i = new Interface();
                
                i.setId(rs.getInt("idinterface"));
                i.setIp(rs.getString("ip"));
                i.setMascara(rs.getString("mascara"));
                i.setNome(rs.getString("nome"));
                con.close();
                return i;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
