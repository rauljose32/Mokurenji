
package model.vpn;

/**
 *Classe para os objetos da configuração de VPN (Tunel).
 * @author thanyla
 */
public class Vpn {
    
    private int id;
    private String ipPontaA;
    private String ipPontaB;
    private String ipTunel;
    private int porta;
    private boolean flag;

    public String getIpPontaA() {
        return ipPontaA;
    }

    public void setIpPontaA(String ipPontoA) {
        this.ipPontaA = ipPontoA;
    }

    public String getIpPontaB() {
        return ipPontaB;
    }

    public void setIpPontaB(String ipPontaB) {
        this.ipPontaB = ipPontaB;
    }

    public String getIpTunel() {
        return ipTunel;
    }

    public void setIpTunel(String ipTunel) {
        this.ipTunel = ipTunel;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
}
