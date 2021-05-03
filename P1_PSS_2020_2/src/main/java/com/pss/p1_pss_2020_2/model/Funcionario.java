package com.pss.p1_pss_2020_2.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayco
 */
public class Funcionario {
    private String nome;
    private String cargo;
    private int idade;
    private int faltas;
    private boolean funcionarioMes;
    private double salarioBase;
    private double salarioTotal;
    private double totalBonus = 0;
    private String tipoBonus; 
    private String admissao;    
    
    private ArrayList<Bonus> bonusDoFuncionario = new ArrayList<>();
    

    public Funcionario(String nome, String cargo, int idade, int faltas, boolean funcionarioMes, String tipoBonus, double SalarioBase, String admissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.faltas = faltas;
        this.funcionarioMes = funcionarioMes;        
        this.tipoBonus = tipoBonus;
        this.salarioBase = salarioBase;
        this.admissao = admissao;
    }
    
    public void adicionarBonus(Bonus bonus){
        if (bonus.getValor() != 0){
            bonusDoFuncionario.add(bonus);
        }
    }
    
    public void calculaTotalBonus(){
        for (Bonus bonus : bonusDoFuncionario){
            totalBonus += bonus.getValor();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    public int getFaltas() {
        return faltas;
    }

    public boolean isFuncionarioMes() {
        return funcionarioMes;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public String getTipoBonus() {
        return tipoBonus;
    }

    public String getAdmissao() {
        return admissao;
    }
   
}
