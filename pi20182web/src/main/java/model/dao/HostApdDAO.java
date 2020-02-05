package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ap.HostApd;
import model.jdbc.Conexao;

/**
 *
 * @author raul
 */
public class HostApdDAO {

    public boolean inserir(HostApd h) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String insertSql = "insert into hostapd (nomeinterface, nomeredewifi, canal, identificador) values (?, ?, ?, 81)";

        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, h.getNomeInterface());
            ps.setString(2, h.getNomeRedeWifi());
            ps.setInt(3, h.getCanal());

            if (ps.executeUpdate() != 0) {

                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostApdDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean update(HostApd n) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update hostapd set identificador = 82 where idhostapd = ?";

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

    public boolean deletar(HostApd h) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String deleteSql = "delete from hostapd where idhostapd = ?";

        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, h.getId());

            if (ps.executeUpdate() != 0) {

                con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostApdDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public HostApd buscarHostapds(int id) {

        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from hostapd where idhostapd = ?";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HostApd hp = new HostApd();
                hp.setId(rs.getInt("idhostapd"));
                hp.setNomeInterface(rs.getString("nomeinterface"));
                hp.setNomeRedeWifi(rs.getString("nomeredewifi"));
                hp.setCanal(rs.getInt("canal"));

                con.close();
                return hp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostApdDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<HostApd> buscarHostapds() {
        Connection con = Conexao.criar();

        if (con == null) {
            return null;
        }
        String selectSql = "select * from hostapd";

        try {
            PreparedStatement ps = con.prepareStatement(selectSql);

            ResultSet rs = ps.executeQuery();

            ArrayList<HostApd> hostApds = new ArrayList();

            while (rs.next()) {

                HostApd hp = new HostApd();
                hp.setId(rs.getInt("idhostapd"));
                hp.setNomeInterface(rs.getString("nomeinterface"));
                hp.setNomeRedeWifi(rs.getString("nomeredewifi"));
                hp.setCanal(rs.getInt("canal"));

                hostApds.add(hp);
            }
            con.close();
            return hostApds;
        } catch (SQLException ex) {
            Logger.getLogger(HostApdDAO.class.getName()).log(Level.SEVERE, null, ex);
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
