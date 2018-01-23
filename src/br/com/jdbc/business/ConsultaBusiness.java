/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.business;

import br.com.jdbc.dao.ConsultaDao;
import br.com.jdbc.dao.IconsultaDao;
import br.com.jdbc.exception.BusinessException;
import br.com.jdbc.exception.DaoException;
import br.com.jdbc.model.Consulta;
import br.com.jdbc.util.ValidacaoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class ConsultaBusiness implements IConsultaBusiness {

    IconsultaDao consultaDao;

    public ConsultaBusiness() {
        this.consultaDao = new ConsultaDao();
    }

    @Override
    public void salvar(Consulta consulta) {
        try {
            ValidacaoUtil.validarConsulta(consulta);
            consultaDao.salvar(consulta);

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                throw new BusinessException(ex.getMessage());
            } catch (BusinessException ex1) {
                Logger.getLogger(ConsultaBusiness.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public List<Consulta> getAll() throws BusinessException {
        List<Consulta> c = new ArrayList<>();
        try {

            return consultaDao.getAll();

        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }

    }

    @Override
    public List<Consulta> getPorCPF(String cpf) throws BusinessException {
        try {
            return this.consultaDao.getConsultasPorCpf(cpf);
        } catch (DaoException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

}
