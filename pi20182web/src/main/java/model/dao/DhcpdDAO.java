package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ap.Dhcpd;
import model.jdbc.Conexao;

/**
 *
 * @author raul
 */
public class DhcpdDAO {

    public boolean inserir(Dhcpd d) {

        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }

        String insertSql = "insert into dhcpd (enderecosubrede, mascarasubrede, rangeinicio, rangefinal, gateway, broadcast, identificador) values (?, ?, ?, ?, ?, ?, 91)";

        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, d.getEnderecoSubrede());
            ps.setString(2, d.getMascaraSubrede());
            ps.setString(3, d.getRangeInicio());
            ps.setString(4, d.getRangeFinal());
            ps.setString(5, d.getGateway());
            ps.setString(6, d.getBroadcast());

            if (ps.executeUpdate() != 0) {
                
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DhcpdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }if (con != null) {

            try {
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }
    
        public boolean update(Dhcpd d) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update dhcpd set identificador = 92 where iddhcpd = ?";

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

    public boolean deletar(Dhcpd d) {

        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String deleteSql = "delete from dhcpd where iddhcpd = ?";

        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, d.getId());

            if (ps.executeUpdate() == 1) {
                
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DhcpdDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public Dhcpd buscarDhcpds(int id) {

        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from dhcpd where iddhcpd = ?";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Dhcpd d = new Dhcpd();

                d.setId(rs.getInt("iddhcpd"));
                d.setEnderecoSubrede(rs.getString("enderecosubrede"));
                d.setMascaraSubrede(rs.getString("mascarasubrede"));
                d.setRangeInicio(rs.getString("rangeinicio"));
                d.setRangeFinal(rs.getString("rangefinal"));
                d.setGateway(rs.getString("gateway"));
                d.setBroadcast(rs.getString("broadcast"));

                con.close();
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Dhcpd> buscarDhcpds() {

        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from dhcpd";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<Dhcpd> dhcpds = new ArrayList();

            while (rs.next()) {

                Dhcpd d = new Dhcpd();

                d.setId(rs.getInt("iddhcpd"));
                d.setEnderecoSubrede(rs.getString("enderecosubrede"));
                d.setMascaraSubrede(rs.getString("mascarasubrede"));
                d.setRangeInicio(rs.getString("rangeinicio"));
                d.setRangeFinal(rs.getString("rangefinal"));
                d.setGateway(rs.getString("gateway"));
                d.setBroadcast(rs.getString("broadcast"));
                
                dhcpds.add(d);
            }
            con.close();
            return dhcpds;
        } catch (SQLException ex) {
            Logger.getLogger(NatEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
