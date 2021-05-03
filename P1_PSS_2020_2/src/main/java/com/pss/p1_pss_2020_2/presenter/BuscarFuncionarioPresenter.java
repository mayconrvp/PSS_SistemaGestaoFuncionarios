/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.model.Observer;
import com.pss.p1_pss_2020_2.view.BuscarFuncionarioView;
import static java.lang.String.format;
import static java.lang.String.format;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayco
 */
public class BuscarFuncionarioPresenter implements Observer{
    private BuscarFuncionarioView view;
    private FuncionarioCollection funcionarios;
    private DefaultTableModel tmFuncionarios;
    private static BuscarFuncionarioPresenter instance;
    
    public BuscarFuncionarioPresenter() {
        this.view = new BuscarFuncionarioView();
        this.funcionarios = FuncionarioCollection.getInstance();
        
        //Gerar a tabela
        gerarTabela();
        
        view.setVisible(true);
    }

    public static BuscarFuncionarioPresenter getInstance(){
        if(instance == null){
            instance = new BuscarFuncionarioPresenter();
        }
        return instance;
    }
    
    
    public void gerarTabela(){
        tmFuncionarios = (DefaultTableModel) view.getTbFuncionarios().getModel();
//        tmFuncionarios = new DefaultTableModel(
//            new Object[][][][]{},
//            new String[]{
//               "Nome", "Idade", "Função", "Salário Base"
//            }
//        );
        view.getTbFuncionarios().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmFuncionarios.setNumRows(0);
        view.getTbFuncionarios().setModel(tmFuncionarios);
    }
    
    public void limpaTabela(){
        if (tmFuncionarios.getRowCount() > 0) {
            for (int i = tmFuncionarios.getRowCount() - 1; i > -1; i--) {
                tmFuncionarios.removeRow(i);
            }
        }
    }

    @Override
    public void update(List<Funcionario> listaFuncionarios) {
        System.out.println("Entrei no Update");
        
        for (Funcionario funcionario : listaFuncionarios) {
            tmFuncionarios.addRow(new Object[]{
                //lista.indexOf(funcionario),
                funcionario.getNome(),
                funcionario.getIdade(),
                funcionario.getCargo(),
                funcionario.getSalarioBase()
            });
        } 
    }
    
    public BuscarFuncionarioView getView() {
        return view;
    }
    
}
