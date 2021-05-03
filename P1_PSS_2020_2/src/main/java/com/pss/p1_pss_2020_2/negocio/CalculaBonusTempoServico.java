/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.negocio;

import com.pss.p1_pss_2020_2.model.Bonus;
import com.pss.p1_pss_2020_2.model.Funcionario;
import static java.lang.Integer.parseInt;

/**
 *
 * @author mayco
 */
public class CalculaBonusTempoServico implements CalculaBonus{

    @Override
    public void calcular(Funcionario funcionario, String data) throws Exception {
        //feito sem usar Date - portanto foi feito isso para calcular os anos (não exato), considerando o formato dd/mm/aaaa
        int admissao = parseInt((funcionario.getAdmissao()).substring(6, 9));
        int anoDataHoje = parseInt(data.substring(6, 9));
        int anos = anoDataHoje - admissao;
        
        double salarioBase = funcionario.getSalarioBase();
        double bonus = 0;
        
        if (anos == 0) {
            bonus = 0;
        } else if (anos <= 5) {
            bonus = salarioBase * 0.02;
        } else if (anos <= 10) {
            bonus = salarioBase * 0.03;
        } else if (anos <= 15) {
            bonus = salarioBase * 0.08;
        } else if (anos <= 20) {
            bonus = salarioBase * 0.10;
        }else if (anos > 20) {
            bonus = salarioBase * 0.15;
        }
        funcionario.adicionarBonus(new Bonus("Tempo de Serviços", bonus, data));
    }
    
}
