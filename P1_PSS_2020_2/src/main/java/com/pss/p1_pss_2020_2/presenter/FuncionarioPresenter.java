/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.view.FuncionarioView;
import com.pss.p1_pss_2020_2.state.FuncionarioPresenterState;
import com.pss.p1_pss_2020_2.state.InclusaoState;
import com.pss.p1_pss_2020_2.state.VisualizacaoState;

/**
 *
 * @author mayco
 */
public class FuncionarioPresenter {

    private FuncionarioView view;
    private FuncionarioPresenterState estado;
    private Funcionario funcionario;
    
    
    public FuncionarioPresenter(Funcionario funcionario) {
        this.view = new FuncionarioView();
        this.funcionario = funcionario;
        
        
        if (funcionario != null){
            this.setEstado(new VisualizacaoState(this));
        }else{
            this.setEstado(new InclusaoState(this));
        }
    }
    
    public void salvar(){
        estado.salvar();
    }
    public void cancelar(){
        estado.cancelar();
    }
    public void editar(){
        estado.editar();
    }
    public void excluir(){
        estado.excluir();
    };

    
    public FuncionarioPresenterState getEstado() {
        return estado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setEstado(FuncionarioPresenterState estado){
        this.estado = estado;
    };

    public FuncionarioView getView() {
        return view;
    }
    
    
}
