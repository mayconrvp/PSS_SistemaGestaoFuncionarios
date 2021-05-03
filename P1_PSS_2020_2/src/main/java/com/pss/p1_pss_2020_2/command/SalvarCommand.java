package com.pss.p1_pss_2020_2.command;

import com.pss.p1_pss_2020_2.collection.FuncionarioCollection;
import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.presenter.FuncionarioPresenter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author mayco
 */
public class SalvarCommand extends Command{
    private FuncionarioCollection funcionarios = FuncionarioCollection.getInstance();;
    
    
    @Override
    public void executar(FuncionarioPresenter presenter){
        try{
            String nome = presenter.getView().getTxtNome().getText();
            String cargo = presenter.getView().getCbCargo().getSelectedItem().toString();
            String bonus = presenter.getView().getCbBonus().getSelectedItem().toString();
            int idade = Integer.parseInt(presenter.getView().getTxtIdade().getText());
            double salario = parseDouble(presenter.getView().getTxtSalario().getText());
            int faltas = Integer.parseInt(presenter.getView().getTxtFaltas().getText());
            String admissao = presenter.getView().getTxtAdmissao().getText();
            boolean funcionarioMes = presenter.getView().getCkbFuncionarioMes().isSelected();

            Funcionario funcionario = new Funcionario(nome, cargo, idade, faltas, funcionarioMes, bonus, salario, admissao);

            //Acionando a lista
            funcionarios.getInstance().add(funcionario);
            
            
            System.out.println(funcionarios.getFuncionarios().indexOf(0));
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso");
            
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao salvar", 0);
            
        }
        //System.out.println(funcionarios.getFuncionarios().get(0).getNome());
            // Funcionario(String nome, String cargo, String idade, int faltas, boolean funcionarioMes, String tipoBonus, double SalarioBase, String admissao) 
        
        
    }
    
}
