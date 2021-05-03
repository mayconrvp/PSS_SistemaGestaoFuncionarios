/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.view.PrincipalView;

/**
 *
 * @author mayco
 */
public class PrincipalPresenter {
    public static void main(String[] args) {
        BuscarFuncionarioPresenter obs1 = new BuscarFuncionarioPresenter();
        obs1.getView().setVisible(false);
        PrincipalView view = new PrincipalView();
        QuantidadeFuncionariosPresenter obs2 = new QuantidadeFuncionariosPresenter(view);
        
        FuncionarioCollection funcionarios = FuncionarioCollection.getInstance();
        funcionarios.registrarObservador(obs1);
        funcionarios.registrarObservador(obs2);
    }    
}
