/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.negocio;

import com.pss.p1_pss_2020_2.model.Funcionario;

/**
 *
 * @author mayco
 */
public interface CalculaBonus {
    public void calcular(Funcionario funcionario, String data) throws Exception;
}
