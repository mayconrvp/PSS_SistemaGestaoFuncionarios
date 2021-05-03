/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.state;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mayco
 */
public class VisualizacaoState extends FuncionarioPresenterState{
    
    private FuncionarioCollection funcionario;
    

    public VisualizacaoState(FuncionarioPresenter presenter) {
        super(presenter);
        this.funcionario = FuncionarioCollection.getInstance();
        
        configuracaoListeners(presenter);
        presenter.getView().setTitle("Visualizar Funcionario");
        ajustarView(presenter);
    }

    public void ajustarView(FuncionarioPresenter presenter){
        presenter.getView().getTxtNome().setEnabled(false);
        presenter.getView().getTxtSalario().setEnabled(false);
        presenter.getView().getTxtIdade().setEnabled(false);
        presenter.getView().getTxtAdmissao().setEnabled(false);
        presenter.getView().getTxtFaltas().setEnabled(false);
        presenter.getView().getCbBonus().setEnabled(false);
        presenter.getView().getCbCargo().setEnabled(false);
        presenter.getView().getCkbFuncionarioMes().setEnabled(false);
        presenter.getView().getBtnSalvar().setEnabled(false);
        presenter.getView().getBtnEditar().setEnabled(true);
        presenter.getView().getBtnFechar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(true);
    }
    
    private void configuracaoListeners(FuncionarioPresenter presenter){
        presenter.getView().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                editar();
            }
        });
        
        presenter.getView().getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    excluir();
                }catch(Exception ex){
                    JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", 0);
                }
            }
        });
        
        presenter.getView().getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cancelar();
            }
        });
    }

}
