/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.p1_pss_2020_2.presenter;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.model.Observer;
import com.pss.p1_pss_2020_2.state.FuncionarioPresenterState;
import com.pss.p1_pss_2020_2.view.BuscarFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mayco
 */
public class BuscarFuncionarioPresenter implements Observer{
    private static BuscarFuncionarioPresenter instance = null;
    private BuscarFuncionarioView view;
    private DefaultTableModel tbmFuncionarios;
    private FuncionarioCollection funcionarios;
    private FuncionarioPresenterState estado;
    private Funcionario funcionario;
    private FuncionarioPresenter presenter;
    private TableRowSorter sorter;
    
    BuscarFuncionarioPresenter(FuncionarioCollection funcionarios){
        view = BuscarFuncionarioView.getInstance();
        view.setVisible(true);
        gerarTabela();
        configurarListeners();
    }

    public static BuscarFuncionarioPresenter getInstance(FuncionarioCollection funcionarios) {
        if (instance == null) {
            instance = new BuscarFuncionarioPresenter(funcionarios);
            
        }
        return instance;
    }
    
    @Override
    public void update(List<Funcionario> listaFuncionarios) {
        System.out.println("Entrei no update");
        limparTabela();
        for (Funcionario funcionario : listaFuncionarios) {
            tbmFuncionarios.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getIdade(),
                funcionario.getCargo(),
                funcionario.getSalarioBase()
            });
        }
    }
    
    public void gerarTabela(){
        tbmFuncionarios = new DefaultTableModel(
                new Object[][][][]{},
                new String[]{"Nome", "Idade", "Cargo", "Salário Base"}
        );

        view.getTbFuncionarios().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbmFuncionarios.setNumRows(0);
        view.getTbFuncionarios().setModel(tbmFuncionarios);
        sorter = new TableRowSorter<TableModel>(tbmFuncionarios);
        view.getTbFuncionarios().setRowSorter(sorter);
    }
    
    private void buscar() throws Exception {
        String nome = view.getTxtNome().getText();
        if (nome.length()==0){
            sorter.setRowFilter(null);
        }else{
            sorter.setRowFilter(RowFilter.regexFilter(nome));
        }
    }
    
   
    private void limparTabela() {
        if (tbmFuncionarios.getRowCount() > 0) {
            for (int i = tbmFuncionarios.getRowCount() - 1; i > -1; i--) {
                tbmFuncionarios.removeRow(i);
            }
        }
    }
    
    public void configurarListeners(){
        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionarioPresenter(funcionario);
            }
        });
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                view.dispose();
            }
        });
        
        view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0){
                int linha = view.getTbFuncionarios().getSelectedRow();
                Funcionario funcSelect = funcionarios.getFuncionarios().get(linha);
                new FuncionarioPresenter(funcSelect);
            }
        });
        
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    buscar();
                } catch (Exception ex) {
                    Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public FuncionarioPresenterState getEstado() {
        return estado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setEstado(FuncionarioPresenterState estado){
        this.estado = estado;
    };
    
    public BuscarFuncionarioView getView() {
        return view;
    }
           
}