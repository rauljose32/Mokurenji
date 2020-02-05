/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import convert.LerXML;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.jdbc.Conexao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author thanyla
 */
public class XmlDAO {

    private Document doc;

    public boolean xml(String tabela) {

        Connection con = Conexao.criar();
        String selectSql = "select * from " + tabela + " where flag";
        try {

            PreparedStatement ps = con.prepareStatement(selectSql);

            if (con == null) {
                return false;
            }

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            if (rs.next()) {

                DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                DocumentBuilder construtor = fabrica.newDocumentBuilder();
                Element raiz;
                doc = construtor.newDocument();
                raiz = doc.createElement("raiz");
                doc.appendChild(raiz);
                int total = rsmd.getColumnCount();

                for (int i = 2; i <= total; i++) {

                    Element e = doc.createElement(rsmd.getColumnName(i));
                    if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                        Text t = doc.createTextNode(Integer.toString(rs.getInt(i)));
                        e.appendChild(t);
                        raiz.appendChild(e);

                    } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {

                        Text t = doc.createTextNode(rs.getString(i));
                        e.appendChild(t);
                        raiz.appendChild(e);

                    }
                }
                ps.close();
                serealiza("documento.xml");
                String alterSql = "update " + tabela + " set flag = false where " + rsmd.getColumnName(1) + " = " + rs.getInt(1);
                ps = con.prepareStatement(alterSql);
                ps.executeUpdate();
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(XmlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    private void serealiza(String xml) {
        try {

            TransformerFactory tFabrica = TransformerFactory.newInstance();
            Transformer trans = tFabrica.newTransformer();
            DOMSource fonte = new DOMSource(doc);
            File saida = new File("/home/thanyla/" + xml);
            StreamResult resultado = new StreamResult(saida);

            trans.transform(fonte, resultado);
            LerXML l = new LerXML();
            l.writeFile(l.convert("/home/thanyla/" + xml));
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.toString());
        }
    }
    public static void main(String[] args) {
        
    }
}
