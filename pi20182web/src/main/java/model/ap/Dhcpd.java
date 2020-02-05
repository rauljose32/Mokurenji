

package model.ap;
/**
 *Classe para os objetos da configuração de AP do arquivo DHCPD.
 * @author thanyla
 */
public class Dhcpd {
    
   private int id;
   private String enderecoSubrede;
   private String mascaraSubrede;
   private String rangeInicio;
   private String rangeFinal;
   private String gateway;
   private String broadcast;
   private boolean flag;

    public String getEnderecoSubrede() {
        return enderecoSubrede;
    }

    public void setEnderecoSubrede(String enderecoSubrede) {
        this.enderecoSubrede = enderecoSubrede;
    }

    public String getMascaraSubrede() {
        return mascaraSubrede;
    }

    public void setMascaraSubrede(String mascaraSubrede) {
        this.mascaraSubrede = mascaraSubrede;
    }

    public String getRangeInicio() {
        return rangeInicio;
    }

    public void setRangeInicio(String rangeInicio) {
        this.rangeInicio = rangeInicio;
    }

    public String getRangeFinal() {
        return rangeFinal;
    }

    public void setRangeFinal(String rangeFinal) {
        this.rangeFinal = rangeFinal;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
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
