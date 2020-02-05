
package model.rota;

/**
 *Classe para os objetos da configuração de rota para host.
 * @author thanyla
 */
public class Host extends Rota{
    
    private int id;
    private String hostDestino;
    private boolean flag;
    
    @Override
    public boolean inserir() {
    //@todo imprementar ação inserir rota para host.
        return false;
    }

    @Override
    public boolean remover() {
    //@todo imprementar ação inserir rota para host. 
        return false;    
    }

    public String getHostDestino() {
        return hostDestino;
    }

    public void setHostDestino(String hostDestino) {
        this.hostDestino = hostDestino;
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
