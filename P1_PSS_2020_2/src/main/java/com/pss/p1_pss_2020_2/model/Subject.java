/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.model;

/**
 *
 * @author mayco
 */
public interface Subject {
    public void registrarObservador(Observer o);
    public void desregistrarObservador(Observer o);
    public void notificar();
    
}
