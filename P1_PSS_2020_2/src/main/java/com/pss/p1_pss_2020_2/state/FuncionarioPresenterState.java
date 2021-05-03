/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.state;

import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;


/**
 *
 * @author mayco
 */
public abstract class FuncionarioPresenterState {
    
    FuncionarioPresenter presenter;

    public FuncionarioPresenterState(FuncionarioPresenter presenter) {
        this.presenter = presenter;
    }
             
    public void salvar(){
        throw new RuntimeException("Não é possível salvar a partir desse estado");
    }
    public void cancelar(){
        presenter.getView().dispose();
    }
    public void editar(){
        throw new RuntimeException("Não é possível editar a partir desse estado");
    }
    public void excluir(){
        throw new RuntimeException("Não é possível excluir a partir desse estado");
    }
}
