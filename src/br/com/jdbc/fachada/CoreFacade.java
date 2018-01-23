/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.fachada;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.business.ConsultaBusiness;
import br.com.jdbc.business.IConsultaBusiness;
import br.com.jdbc.business.IMedicoBusiness;
import br.com.jdbc.business.IPacienteBusiness;
import br.com.jdbc.business.MedicoBusiness;
import br.com.jdbc.business.PacienteBusiness;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Medico;
import br.com.jdbc.model.Paciente;
import java.util.List;

public class CoreFacade implements ICoreFacade {
    
    IPacienteBusiness pacienteBusiness;
    IMedicoBusiness medicoBusiness;
    IConsultaBusiness consultaBusiness;
    
    public CoreFacade() {
        this.pacienteBusiness = new PacienteBusiness();
        this.medicoBusiness = new MedicoBusiness();
        this.consultaBusiness = new ConsultaBusiness();
    }
    
    @Override
    public Paciente salvarPaciente(Paciente paciente) throws BusinessException {
        return this.pacienteBusiness.salvar(paciente);
    }
    
    @Override
    public void excluirContato(int id) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Paciente editarPaciente(Paciente paciente) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Paciente> getPacientes() throws BusinessException {
        return pacienteBusiness.getAll(null);
        
    }
    
    @Override
    public Paciente getPacientePorCpf(String cpf) throws BusinessException {
        return this.pacienteBusiness.getPorCpf(cpf);
    }
    
    @Override
    public Paciente getPacientePorId(int id) throws BusinessException {
        return this.pacienteBusiness.getPorId(id);
        
    }
    
    @Override
    public List<PacienteAdapter> getPacientesAdapter() throws BusinessException {
        return this.pacienteBusiness.getAllAdapter();
    }
    
    @Override
    public List<Paciente> getPacientesPorBusca(String busca) throws BusinessException {
        
        return this.pacienteBusiness.getAll(busca);
    }
    
    @Override
    public Medico salvarMedico(Medico medico) throws BusinessException {
        return this.medicoBusiness.salvar(medico);
    }
    
    @Override
    public Medico getMedicoPorCRM(int crm) throws BusinessException {
        return this.medicoBusiness.getPorCrm(crm);
    }
    
    public List<Medico> getMedicos() throws BusinessException {
        return this.medicoBusiness.getAll();        
    }
    
    @Override
    public void salvaConsulta(Consulta consulta) throws BusinessException {
        this.consultaBusiness.salvar(consulta);
    }
    
    @Override
    public List<Consulta> getConsutlas() throws BusinessException {
        return this.consultaBusiness.getAll();
    }
    
    @Override
    public List<Consulta> getConsutlasPorCPFPaciente(String cpf) throws BusinessException {
        return this.consultaBusiness.getPorCPF(cpf);
    }
    
}
