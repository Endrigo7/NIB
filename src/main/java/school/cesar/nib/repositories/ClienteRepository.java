package school.cesar.nib.repositories;

import school.cesar.nib.entities.Cliente;

public interface ClienteRepository {

    void salvar(Cliente cliente);

    Cliente buscar(String cpf);

}
