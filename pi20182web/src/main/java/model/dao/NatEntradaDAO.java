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
import model.nat.NatEntrada;

/**
 *
 * @author raul
 */
public class NatEntradaDAO {

    public boolean inserir(NatEntrada n) {

        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }

        String insertSql = "insert into natentrada (iporigem, ipdestino, portaorigem, portadestino, identificador) values (?, ?, ?, ?, 51)";
        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, n.getIpOrigem());
            ps.setString(2, n.getIpDestino());
            ps.setInt(3, n.getPortaOrigem());
            ps.setInt(4, n.getPortaDestino());

            if (ps.executeUpdate() != 0) {

                con.close();
                return true;
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

        return false;
    }

    public boolean update(NatEntrada n) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update natentrada set identificador = 52 where idnatentrada = ?";

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

    public boolean deletar(NatEntrada n) {

        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String deleteSql = "delete from natentrada where idnatentrada = ?";

        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, n.getId());

            if (ps.executeUpdate() == 1) {

                con.close();
                return true;
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

        return false;
    }

    public NatEntrada buscarNatsEntrada(int id) {

        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }

        String selectSql = "select * from natentrada where idnatentrada = ?";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                NatEntrada ne = new NatEntrada();

                ne.setId(rs.getInt("idnatentrada"));
                ne.setIpOrigem(rs.getString("iporigem"));
                ne.setIpDestino(rs.getString("ipdestino"));
                ne.setPortaOrigem(rs.getInt("portaorigem"));
                ne.setPortaDestino(rs.getInt("portadestino"));

                con.close();
                return ne;
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

    public List<NatEntrada> buscarNatsEntrada() {
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from natentrada";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);

            ResultSet rs = ps.executeQuery();

            ArrayList<NatEntrada> natsEntrada = new ArrayList();

            while (rs.next()) {

                NatEntrada ne = new NatEntrada();

                ne.setId(rs.getInt("idnatentrada"));
                ne.setIpDestino(rs.getString("ipdestino"));
                ne.setIpOrigem(rs.getString("iporigem"));
                ne.setPortaDestino(rs.getInt("portadestino"));
                ne.setPortaOrigem(rs.getInt("portaorigem"));

                natsEntrada.add(ne);

            }
            con.close();
            return natsEntrada;
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
