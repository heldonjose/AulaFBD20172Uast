/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.model;

/**
 *
 * @author prof Heldon
 */
public class Medico {
    
    private int id;
    private String nome;
    private int CRM;
    private String especializacao;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCRM() {
        return CRM;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nome=" + nome + ", CRM=" + CRM + ", especializacao=" + especializacao + '}';
    }
}
