/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.model;

import com.pss.p1_pss_2020_2.presenter.PrincipalPresenter;

/**
 *
 * @author mayco
 */
public class App {
    public static void main(String[] args) {
        try{
            PrincipalPresenter principalPresenter = PrincipalPresenter.getInstance();
            principalPresenter.getView().setVisible(true);
        }catch(Exception ex){
            
        }
    }
}
