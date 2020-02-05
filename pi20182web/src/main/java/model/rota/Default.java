
package model.rota;

/**
 * Classe para os objetos da configuração de rota default.
 * @author thanyla
 */
public class Default extends Rota{
    
    private int id;
    private boolean flag;

    @Override
    public boolean inserir() {
        //@todo implementar ação de inserir rota default
        return false; 
    }

    @Override
    public boolean remover() {
        //@todo implementar ação de remover rota default
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
