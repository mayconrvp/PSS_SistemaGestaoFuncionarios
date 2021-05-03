package com.pss.p1_pss_2020_2.collection;

import com.pss.p1_pss_2020_2.model.Funcionario;
import com.pss.p1_pss_2020_2.model.Observer;
import com.pss.p1_pss_2020_2.model.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mayco
 */
public class FuncionarioCollection implements Subject{
    private List<Observer> observadores = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    private static FuncionarioCollection instance;
    
    private FuncionarioCollection(){
    }
    
    public static FuncionarioCollection getInstance(){
        if(instance == null){
            instance = new FuncionarioCollection();
        }
        return instance;
    }

    @Override
    public void registrarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void desregistrarObservador(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        System.out.println("Estou notificando");
        for (Observer observer : observadores){
            observer.update(this.getFuncionarios());
        }
    }
    
    public void add(Funcionario funcionario){
        funcionarios.add(funcionario);
        notificar();
    }
    
    public void remove(Funcionario funcionario){
        funcionarios.remove(funcionario);
        notificar();
    }
    
    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public List<Observer> getObservadores() {
        return observadores;
    }
}
