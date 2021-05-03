/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.state;

import com.pss.p1_pss_2020_2.command.SalvarCommand;
import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mayco
 */
public class InclusaoState extends FuncionarioPresenterState{

    public InclusaoState(FuncionarioPresenter presenter) {
        super(presenter);
        presenter.getView().setEnabled(false);
        presenter.getView().setTitle("Novo Funcionário");
        presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getBtnEditar().setEnabled(false);
        presenter.getView().getBtnFechar().setEnabled(true);
        presenter.getView().setEnabled(true);
        
        presenter.getView().getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    salvar();
                    
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
                    System.out.println(ex.getMessage());
                }
            }
        });
        
        presenter.getView().getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cancelar();
            }
        });
        
        presenter.getView().setVisible(true);
    }

    @Override
    public void salvar(){
        new SalvarCommand().executar(presenter);
        presenter.setEstado(new VisualizacaoState(presenter));
    }    
}
