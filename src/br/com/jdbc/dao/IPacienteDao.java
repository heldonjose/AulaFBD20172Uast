/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Paciente;
import java.util.List;


public interface IPacienteDao {
    
    
    public Paciente salvar(Paciente paciente) throws DaoException;
    
    public List<Paciente> getAll() throws DaoException;
    public List<Paciente> getPorBusca(String busca) throws DaoException;

    public List<PacienteAdapter> getAllAdapter()throws DaoException;

    public Paciente getPorId(int id)throws DaoException;

    public Paciente getPorCpf(String cpf)throws DaoException;

    
}
