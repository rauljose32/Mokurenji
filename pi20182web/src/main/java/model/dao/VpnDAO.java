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
import model.vpn.Vpn;

/**
 *
 * @author raul
 */
public class VpnDAO {

    public boolean inserir(Vpn v) {
        Connection con = Conexao.criar();
        
        if (con == null) {
            return false;
        }
        
        String insertSql = "insert into vpn (ippontaa, ippontab, iptunel, porta, identificador) values (?, ?, ?, ?, 71)";

        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, v.getIpPontaA());
            ps.setString(2, v.getIpPontaB());
            ps.setString(3, v.getIpTunel());
            ps.setInt(4, v.getPorta());

            if (ps.executeUpdate() != 0) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VpnDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
        public boolean update(Vpn v) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update vpn set identificador = 72 where idvpn = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, v.getId());

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

    public boolean delete() {
        Connection con = Conexao.criar();
        if (con == null) {
            return false;
        }
        String deleteSql = "delete from vpn";

        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            
            if (ps.executeUpdate() == 1) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VpnDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public Vpn buscarVpn(int id) {

        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from vpn where idvpn = ?";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vpn v = new Vpn();
                v.setId(rs.getInt("idvpn"));
                v.setIpPontaA(rs.getString("ippontaa"));
                v.setIpPontaB(rs.getString("ippontab"));
                v.setIpTunel(rs.getString("iptunel"));
                v.setPorta(rs.getInt("porta"));
                con.close();
                return v;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VpnDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        public Vpn buscarPrimeiroRegistro() {

        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from vpn";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);


            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Vpn v = new Vpn();
                v.setId(rs.getInt("idvpn"));
                v.setIpPontaA(rs.getString("ippontaa"));
                v.setIpPontaB(rs.getString("ippontab"));
                v.setIpTunel(rs.getString("iptunel"));
                v.setPorta(rs.getInt("porta"));
                con.close();
                return v;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VpnDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Vpn> buscarVpns() {
        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from vpn";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);

            ResultSet rs = ps.executeQuery();

            ArrayList<Vpn> vpns = new ArrayList();

            while (rs.next()) {
                
                Vpn v = new Vpn();
                
                v.setId(rs.getInt("idvpn"));
                v.setIpPontaA(rs.getString("ippontaa"));
                v.setIpPontaB(rs.getString("ippontab"));
                v.setIpTunel(rs.getString("iptunel"));
                v.setPorta(rs.getInt("porta"));
                
                vpns.add(v);
            }
            con.close();
            return vpns;
        } catch (SQLException ex) {
            Logger.getLogger(VpnDAO.class.getName()).log(Level.SEVERE, null, ex);
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
