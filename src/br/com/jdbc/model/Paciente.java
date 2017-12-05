
package br.com.jdbc.model;

import java.util.ArrayList;
import java.util.List;


public class Paciente {
    private Integer id;
    private String nome;
    private String cpf;
    private Endereco end;
    
    List<Contato> contatos;

    public Paciente() {
        this.contatos = new ArrayList();
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }
    
    public void addContato(Contato contato){
        this.contatos.add(contato);
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", end=" + end + ", contatos=" + contatos + '}';
    }

   

  
    
    
}
