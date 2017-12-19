/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.dao.IMedicoDao;
import br.com.jdbc.dao.MedicoDao;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.model.Medico;
import br.com.jdbc.util.ValidacaoUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class MedicoBusiness implements IMedicoBusiness{
    
    private IMedicoDao daoMedico;

    public MedicoBusiness() {
        this.daoMedico = new MedicoDao();
    }
    
    
    
    
    @Override
    public Medico salvar(Medico medico) throws BusinessException {
        try {
            ValidacaoUtil.validarMedico(medico);
            medico = daoMedico.salvar(medico);
            return medico;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<Medico> getAll(String busca) throws BusinessException {
        try {
            if (busca == null || busca.isEmpty()) {
                return daoMedico.getAll();
            }
            
            return daoMedico.getPorBusca(busca);

        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public Medico getPorId(int id) throws BusinessException {
        try {
            return daoMedico.getPorId(id);
        } catch (DaoException ex) {
          
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public Medico getPorCrm(int crm) throws BusinessException {
        try {
            return daoMedico.getPorCrm(crm);
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<Medico> getAll() throws BusinessException {
        try {
            return daoMedico.getAll();
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
               
     
    }

   

   

      
}
