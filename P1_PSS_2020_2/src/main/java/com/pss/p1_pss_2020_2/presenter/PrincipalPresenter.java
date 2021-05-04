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
    
    
    private static PrincipalPresenter instance = null;
    private PrincipalView view;
    private FuncionarioCollection funcionarios;
    
    
    PrincipalPresenter(){
        view = new PrincipalView();
        funcionarios = FuncionarioCollection.getInstance();
        registrarObservadores();
        
    }
    
    public static PrincipalPresenter getInstance() throws Exception {
        if (instance == null) {
            instance = new PrincipalPresenter();
        }
        return instance;
    }
    
    public void registrarObservadores(){
         BuscarFuncionarioPresenter obs1 = new BuscarFuncionarioPresenter(funcionarios);
         QuantidadeFuncionariosPresenter obs2 = new QuantidadeFuncionariosPresenter(view);
         obs1.getView().setVisible(false);
         funcionarios.registrarObservador(obs1);
         funcionarios.registrarObservador(obs2);
    }

    public PrincipalView getView() {
        return view;
    }
}
