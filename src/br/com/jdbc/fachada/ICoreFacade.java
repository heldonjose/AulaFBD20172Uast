/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.fachada;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Medico;
import br.com.jdbc.model.Paciente;

import java.util.List;

public interface ICoreFacade {

    public Paciente salvarPaciente(Paciente paciente) throws BusinessException;

    public void excluirContato(int id) throws BusinessException;

    public Paciente editarPaciente(Paciente paciente) throws BusinessException;

//Select
    public List<Paciente> getPacientes() throws BusinessException;

    public List<PacienteAdapter> getPacientesAdapter() throws BusinessException;

    public Paciente getPacientePorCpf(String cpf) throws BusinessException;

    public Paciente getPacientePorId(int id) throws BusinessException;

    public List<Paciente> getPacientesPorBusca(String busca) throws BusinessException;

    public Medico salvarMedico(Medico m) throws BusinessException;

    public Medico getMedicoPorCRM(int crm) throws BusinessException;

    public List<Medico> getMedicos() throws BusinessException;

    public void salvaConsulta(Consulta c) throws BusinessException;

    public List<Consulta> getConsutlas() throws BusinessException;

    public List<Consulta> getConsutlasPorCPFPaciente(String cpf) throws BusinessException;

}
