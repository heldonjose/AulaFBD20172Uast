/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.model;

public class Contato {

    private Integer id;
    private String descricao;
    private String tipo;

    public Contato(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + '}';
    }
    
    

}
