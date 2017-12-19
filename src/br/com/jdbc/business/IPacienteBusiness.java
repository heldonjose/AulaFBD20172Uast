/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Paciente;
import java.util.List;


public interface IPacienteBusiness {
    
    public Paciente salvar(Paciente paciente)throws BusinessException;

    public List<Paciente> getAll(String busca) throws BusinessException;

    public List<PacienteAdapter> getAllAdapter() throws BusinessException;

    public Paciente getPorId(int id)  throws BusinessException;

    public Paciente getPorCpf(String cpf)  throws BusinessException;

    
}
