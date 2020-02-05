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
import model.rota.Rede;

/**
 *
 * @author raul
 */
public class RedeDAO {

    public boolean inserir(Rede r) {
        Connection con = Conexao.criar();
        
        if (con == null) {
            return false;
        }
        
        String insertSql = "insert into rotarede (gateway, rededestino, mascara, identificador) values (?, ?, ?, 41)";

        try {
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, r.getGateway());
            ps.setString(2, r.getRedeDestino());
            ps.setString(3, r.getMascara());

            if (ps.executeUpdate() != 0) {
                
                con.close();
                return true;
            }

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
        return false;
    }
    
        public boolean update(Rede r) {
        Connection con = Conexao.criar();

        if (con == null) {
            return false;
        }
        String updateSql = "update rotarede set identificador = 42 where idrede = ?";

        try {
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setInt(1, r.getId());

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

    public boolean deletar(Rede r) {
        Connection con = Conexao.criar();
         if (con == null) {
            return false;
        }
        String deleteSql = "delete from rotarede where idrede = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, r.getId());
            
            if (ps.executeUpdate() == 1) {
                
                con.close();
                return true;
            }
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

        return false;
    }

    public List<Rede> buscarRedes() {
        Connection con = Conexao.criar();
        if (con == null) {
            return null;
        }
        String selectSql = "select * from rotarede";

        try {

            PreparedStatement ps = con.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Rede> redes = new ArrayList();

            while (rs.next()) {

                Rede rede = new Rede();
                rede.setId(rs.getInt("idrede"));
                rede.setRedeDestino(rs.getString("rededestino"));
                rede.setMascara(rs.getString("mascara"));
                rede.setGateway(rs.getString("gateway"));

                redes.add(rede);
            }
            con.close();
            return redes;
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

    public Rede buscarRedes(int id) {

        Connection con = Conexao.criar();
        
        if (con == null) {
            return null;
        }
        String selectsql = "select * from rotarede  where idrede = ?";

        try {

            PreparedStatement ps = con.prepareStatement(selectsql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Rede rede = new Rede();

                rede.setId(rs.getInt("idrede"));
                rede.setGateway(rs.getString("gateway"));
                rede.setMascara("mascara");
                rede.setRedeDestino("rededestino");
                
                con.close();
                return rede;
            }

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

}
