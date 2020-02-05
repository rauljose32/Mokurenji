/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nat;

import model.configuracao.AcoesDeConfiguracao;

/**
 *Classe para os objetos da configuração de nat de saída.
 * @author thanyla
 */
public class NatEntrada implements AcoesDeConfiguracao{

    private int id;
    private String ipOrigem;
    private int portaOrigem;
    private String ipDestino;
    private int portaDestino;
    private boolean flag;

    public String getIpDestino() {
        return ipDestino;
    }

    public void setIpDestino(String ipDestino) {
        this.ipDestino = ipDestino;
    }

    public int getPortaDestino() {
        return portaDestino;
    }

    public void setPortaDestino(int portaDestino) {
        this.portaDestino = portaDestino;
    }

    public String getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(String ipOrigem) {
        this.ipOrigem = ipOrigem;
    }

    public int getPortaOrigem() {
        return portaOrigem;
    }

    public void setPortaOrigem(int portaOrigem) {
        this.portaOrigem = portaOrigem;
    }
    
    @Override
    public boolean inserir() {
        //@todo imprementar ação inserir nat de saída. 
        return false; 
    }

    @Override
    public boolean remover() {
        //@todo imprementar ação remove nat de saída. 
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
