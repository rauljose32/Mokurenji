
package model.ap;

/**
 *Classe para os objetos da configuração de AP do arquivo HOSTAPD.
 * @author thanyla
 */
public class HostApd {
    
    private int id;
    private String nomeInterface;
    private String nomeRedeWifi;
    private int canal;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getNomeInterface() {
        return nomeInterface;
    }

    public void setNomeInterface(String nomeInterface) {
        this.nomeInterface = nomeInterface;
    }

    public String getNomeRedeWifi() {
        return nomeRedeWifi;
    }

    public void setNomeRedeWifi(String nomeRedeWifi) {
        this.nomeRedeWifi = nomeRedeWifi;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
