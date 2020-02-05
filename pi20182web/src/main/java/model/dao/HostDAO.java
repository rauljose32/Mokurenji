
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.jdbc.Conexao;
import model.rota.Host;
import model.rota.Rede;

/**
 *
 * @author raul
 */
public class HostDAO {

    public boolean inserir(Host h){
        Connection con = Conexao.criar();
         if (con == null) {
            return false;
        }
        String insertSql = "insert into rotahost (gateway, hostdestino, identificador) values (?, ?, 31);";
        
        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, h.getGateway());
            ps.setString(2, h.getHostDestino());
            
            if(ps.executeUpdate() == 1 ){
                con.close();
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HostDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
        public boolean update(Host h) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update rotahost set identificador = 32 where idhost = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, h.getId());

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
    
    public boolean deletar(Host h){
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }

        String deleteSql = "delete from rotahost where idhost = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, h.getId());
            
            if(ps.executeUpdate() != 0){
                
                con.close();
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HostDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public ArrayList<Host> buscarRedes() {
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }

        String selectSql = "select * from rotahost";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Host> hosts = new ArrayList();

            while (rs.next()) {
                
                Host host = new Host();
                host.setId(rs.getInt("idhost"));
                host.setHostDestino(rs.getString("hostdestino"));
                host.setGateway(rs.getString("gateway"));
               
                hosts.add(host);
            }
            
            con.close();
            return hosts;
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
    
    public Host buscarRedes(int id){
        
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }

        String selectSql = "select * from rotahost where idhost = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Host host = new Host();
                
                host.setId(rs.getInt("idHost"));
                host.setGateway(rs.getString("gateway"));
                host.setHostDestino(rs.getString("hostdestino"));

                con.close();
                
                return host;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostDAO.class.getName()).log(Level.SEVERE, null, ex);
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
