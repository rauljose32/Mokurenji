
package model.rota;

import model.configuracao.AcoesDeConfiguracao;

/**
 * Classe para os objetos da configuração de rota.
 * @author thanyla
 */
public abstract class Rota implements AcoesDeConfiguracao {
    
    private String gateway;

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
    
}
