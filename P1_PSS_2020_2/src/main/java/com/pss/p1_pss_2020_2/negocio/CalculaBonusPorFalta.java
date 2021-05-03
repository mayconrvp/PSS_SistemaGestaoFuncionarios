/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.negocio;

import com.pss.p1_pss_2020_2.model.Bonus;
import com.pss.p1_pss_2020_2.model.Funcionario;

/**
 *
 * @author mayco
 */
public class CalculaBonusPorFalta implements CalculaBonus{

    @Override
    public void calcular(Funcionario funcionario, String data) throws Exception {
        int faltas = funcionario.getFaltas();
        double salarioBase = funcionario.getSalarioBase();
        double bonus = 0;
        
        if (faltas == 0) {
            bonus = salarioBase * 0.10;
        } else if (faltas <= 3) {
            bonus = salarioBase * 0.05;
        } else if (faltas <= 5 || faltas>6) {
            bonus = salarioBase * 0.01;
        }
        funcionario.adicionarBonus(new Bonus("Assiduidade", bonus, data));
    }
    
}
