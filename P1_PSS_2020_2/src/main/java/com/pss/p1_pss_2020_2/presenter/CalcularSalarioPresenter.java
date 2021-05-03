/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.view.CalcularSalarioView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayco
 */
public class CalcularSalarioPresenter {
    private CalcularSalarioView view;
    private FuncionarioCollection funcionarios;
    private DefaultTableModel tmSalarios;
    private static CalcularSalarioPresenter instance;
    
    public CalcularSalarioPresenter() {
        this.view = new CalcularSalarioView();
        this.funcionarios = FuncionarioCollection.getInstance();
        
        //Gerar a tabela
        
        view.setVisible(true);
    }
    
    public static CalcularSalarioPresenter getInstance(){
        if(instance == null){
            instance = new CalcularSalarioPresenter();
        }
        return instance;
    }

    public CalcularSalarioView getView() {
        return view;
    }
    
    
}
