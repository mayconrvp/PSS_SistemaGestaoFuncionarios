/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.command;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author mayco
 */
public class ExcluirCommand extends Command {
    private FuncionarioCollection funcionarios;

    public void excluir(FuncionarioPresenter presenter) {
        this.funcionarios = FuncionarioCollection.getInstance();
        
        for (int i = 0; i<funcionarios.getFuncionarios().size(); i++){
            Funcionario func = funcionarios.getFuncionarios().get(i);
            if (func.getNome() == presenter.getView().getTxtNome().toString()){
                funcionarios.remove(func);
                JOptionPane.showMessageDialog(presenter.getView(), "Funcionário excluído");
            }
        }
    }
    
    
}
