package school.cesar.nib.repositories;

import school.cesar.nib.entities.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepositoryArrayList {

    private static final ContaRepositoryArrayList INSTANCIA = new ContaRepositoryArrayList();

    private List<Conta> contas;

    private ContaRepositoryArrayList(){
        contas = new ArrayList<>();
    }

    public static ContaRepositoryArrayList getInstancia(){
        return INSTANCIA;
    }

    public void salvar(Conta conta){
        contas.add(conta);
    }

    public Conta buscar(String numero){
        return contas
                .stream()
                .filter(conta -> conta.getNumero().equals(numero))
                .findFirst()
                .get();
    }
}
