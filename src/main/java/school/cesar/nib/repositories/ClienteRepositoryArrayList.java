package school.cesar.nib.repositories;

import school.cesar.nib.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryArrayList implements ClienteRepository {

    private static final ClienteRepositoryArrayList INSTANCIA = new ClienteRepositoryArrayList();

    private List<Cliente> clientes;

    private ClienteRepositoryArrayList(){
        clientes = new ArrayList<>();
    }

    public static ClienteRepositoryArrayList getInstancia(){
        return INSTANCIA;
    }

    public void salvar(Cliente cliente){
        System.out.println("Usei a class " + getClass().getSimpleName());
        clientes.add(cliente);
    }

    public Cliente buscar(String cpf){
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCpf().equals(cpf)){
                return clientes.get(i);
            }
        }

        return null;
    }
}
