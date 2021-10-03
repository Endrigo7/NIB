package school.cesar.nib.repositories;

import school.cesar.nib.entities.Cliente;

public class ClienteRepositoryVetor implements ClienteRepository{
    private static final ClienteRepositoryVetor INSTANCIA = new ClienteRepositoryVetor();

    private Cliente[] clientes = new Cliente[2];
    private int indice = 0;

    private ClienteRepositoryVetor(){
    }

    public static ClienteRepositoryVetor getInstancia(){
        return INSTANCIA;
    }


    @Override
    public void salvar(Cliente cliente) {
        System.out.println("Usei a class " + getClass().getSimpleName());
        clientes[indice] = cliente;
        indice++;
    }

    @Override
    public Cliente buscar(String cpf) {
        return null;
    }
}
