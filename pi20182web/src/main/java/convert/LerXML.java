/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LerXML {

//    public static void main(String[] args) {
//        LerXML l = new LerXML();
//       l.writeFile(l.convert("/home/thanyla/finalmente/pi20182webdocumento.xml"));
//    }

    public String convert(String caminho) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(caminho);

            NodeList lista = doc.getElementsByTagName("raiz");

            int tamanhoLista = lista.getLength();

            String texto = null;

            for (int i = 0; i < tamanhoLista; i++) {

                Node noraiz = lista.item(i);
                if (noraiz.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) noraiz;

                    texto = elemento.getAttribute("id");
                    
                    //System.out.println(">>>>>>>>>>>>>>>>>>" + id);

                    NodeList listafilhosderaiz = elemento.getChildNodes();

                    int tamanhoListaFilhos = listafilhosderaiz.getLength();

                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listafilhosderaiz.item(j);

                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            
                            texto+=elementoFilho.getTextContent()+" ";
                        }
                    }
                }

                System.out.println(texto);
                return texto;
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void writeFile(String texto) {
        FileWriter arquivo;
        try {
            arquivo = new FileWriter(new File("/home/thanyla/comandos"));
            arquivo.write(texto);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
