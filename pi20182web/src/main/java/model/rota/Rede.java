
package model.rota;

/**
 *Classe para os objetos da configuração de rota para rede.
 * @author thanyla
 */
public class Rede extends Rota{
    
    private int id;
    private String redeDestino;
    private String mascara;
    private boolean flag;
    
    public String getRedeDestino() {
        return redeDestino;
    }

    public void setRedeDestino(String redeDestino) {
        this.redeDestino = redeDestino;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }
    
    @Override
    public boolean inserir() {
        //@todo imprementar ação inserir rota de rede 
        return false;
    }

    @Override
    public boolean remover() {
        //@todo imprementar ação remover rota de rede
        return false;
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
