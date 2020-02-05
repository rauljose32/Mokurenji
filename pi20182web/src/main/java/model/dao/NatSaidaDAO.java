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
import model.nat.NatSaida;

/**
 *
 * @author raul
 */
public class NatSaidaDAO {

    public boolean inserir(NatSaida n) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }

        String insertSql = "insert into natsaida (interface, identificador) values (?, 61)";
        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, n.getNomeInterface());

            if (ps.executeUpdate() != 0) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NatSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
        public boolean update(NatSaida n) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update natsaida set identificador = 62 where idsaida = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, n.getId());

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

    public boolean deletar(NatSaida n) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }

        String deleteSql = "delete from natsaida where idnatsaida = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, n.getId());
            
            if (ps.executeUpdate() == 1) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NatSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public NatSaida buscarNatsSaida(int id) {

        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }

        String selectSql = "select * from natsaida where idnatsaida = ?";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                NatSaida ns = new NatSaida();

                ns.setId(rs.getInt("idnatsaida"));
                ns.setNomeInterface(rs.getString("interface"));

                con.close();
                return ns;
            }

        } catch (SQLException ex) {
            Logger.getLogger(NatSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<NatSaida> buscarNatsSaida() {
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }

        String selectSql = "select * from natsaida";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);

            ResultSet rs = ps.executeQuery();

            ArrayList<NatSaida> natsSaida = new ArrayList();

            while (rs.next()) {

                NatSaida ns = new NatSaida();

                ns.setId(rs.getInt("idnatsaida"));
                ns.setNomeInterface(rs.getString("interface"));

                natsSaida.add(ns);

            }
            con.close();
            return natsSaida;
        } catch (SQLException ex) {
            Logger.getLogger(NatSaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
