/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.model.Observer;
import com.pss.p1_pss_2020_2.view.PrincipalView;
import static java.lang.String.valueOf;
import java.util.List;

/**
 *
 * @author mayco
 */
public class QuantidadeFuncionariosPresenter implements Observer{
    
    private PrincipalView view;

    public QuantidadeFuncionariosPresenter(PrincipalView view) {
        this.view = view;
    }    

    @Override
    public void update(List<Funcionario> lista) {
        view.getLblQtd().setText(valueOf(lista.size()));
    }
    
}
