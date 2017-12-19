/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.adapter.PacienteAdapter;
import br.com.jdbc.dao.IPacienteDao;
import br.com.jdbc.dao.PacienteDao;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Paciente;
import br.com.jdbc.util.Util;
import br.com.jdbc.util.ValidacaoUtil;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class PacienteBusiness implements IPacienteBusiness {

    private IPacienteDao daoPaciente;

    public PacienteBusiness() {
        this.daoPaciente = new PacienteDao();
    }

    @Override
    public Paciente salvar(Paciente paciente) throws BusinessException {

        try {
            ValidacaoUtil.validarPaciente(paciente);
            
            if(paciente.getCpf().length() > 11){
                paciente.setCpf(Util.removerCaracteresEspeciais(paciente.getCpf()));
            }
            
            paciente = daoPaciente.salvar(paciente);
            return paciente;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<Paciente> getAll(String busca) throws BusinessException {

        try {
            if (busca == null || busca.isEmpty()) {
                return daoPaciente.getAll();

            }
            
            return daoPaciente.getPorBusca(busca);

        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<PacienteAdapter> getAllAdapter() throws BusinessException {
        try {
            return daoPaciente.getAllAdapter();
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public Paciente getPorId(int id) throws BusinessException {
        try {
            return daoPaciente.getPorId(id);
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public Paciente getPorCpf(String cpf) throws BusinessException {
       try {
            return daoPaciente.getPorCpf(cpf);
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

}
