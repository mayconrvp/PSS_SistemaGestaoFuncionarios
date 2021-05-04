/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.state;

import com.pss.p1_pss_2020_2.command.SalvarCommand;
import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;

/**
 *
 * @author mayco
 */
public class EdicaoState extends FuncionarioPresenterState{
    public EdicaoState(FuncionarioPresenter presenter) {
        super(presenter);
        
        presenter.getView().setEnabled(false);
        presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnFechar().setText("Cancelar");        
        presenter.getView().getBtnFechar().setEnabled(true);        
        presenter.getView().getBtnExcluir().setEnabled(false);                        
        presenter.getView().getBtnEditar().setEnabled(false);
        
        presenter.getView().getTxtNome().setEnabled(true);
        presenter.getView().getTxtAdmissao().setEnabled(true);
        presenter.getView().getTxtFaltas().setEnabled(true);
        presenter.getView().getTxtIdade().setEnabled(true);
        presenter.getView().getTxtSalario().setEnabled(true);
        presenter.getView().getCbBonus().setEnabled(true);        
        presenter.getView().getCbCargo().setEnabled(true);
        presenter.getView().getCkbFuncionarioMes().setEnabled(true);
        
    }

    @Override
    public void salvar (){
        new SalvarCommand().executar(presenter);                
        presenter.setEstado(new VisualizacaoState(presenter));
    }
}
