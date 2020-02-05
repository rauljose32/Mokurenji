/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nat;

import model.configuracao.AcoesDeConfiguracao;

/**
 *Classe para os objetos da configuração de nat de entrada.
 * @author thanyla
 */
public class NatSaida implements AcoesDeConfiguracao{
    
    private int id;
    private String nomeInterface;
    private boolean flag;
    
    
    @Override
    public boolean inserir() {
    //@todo imprementar ação inserir nat de entrada. 
        return false;     
    }

    @Override
    public boolean remover() {
    //@todo imprementar ação remove nat de entrada. 
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

    public String getNomeInterface() {
        return nomeInterface;
    }

    public void setNomeInterface(String nomeInterface) {
        this.nomeInterface = nomeInterface;
    }

    
}
