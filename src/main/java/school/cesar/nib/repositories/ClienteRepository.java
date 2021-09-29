package school.cesar.nib.repositories;

import school.cesar.nib.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static final ClienteRepository INSTANCIA = new ClienteRepository();

    private List<Cliente> clientes;

    private ClienteRepository(){
        clientes = new ArrayList<>();
    }

    public static ClienteRepository getInstancia(){
        return INSTANCIA;
    }

    public void salvar(Cliente cliente){
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
