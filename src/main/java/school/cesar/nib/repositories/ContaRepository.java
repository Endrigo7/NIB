package school.cesar.nib.repositories;

import school.cesar.nib.entities.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository {

    private static final ContaRepository INSTANCIA = new ContaRepository();

    private List<Conta> contas;

    private ContaRepository(){
        contas = new ArrayList<>();
    }

    public static ContaRepository getInstancia(){
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
