package school.cesar.nib.services;

import school.cesar.nib.entities.Cliente;
import school.cesar.nib.exceptions.CpfInvalidoException;
import school.cesar.nib.repositories.ClienteRepository;
import school.cesar.nib.repositories.ClienteRepositoryVetor;
import school.cesar.nib.util.CpfUtil;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        clienteRepository = ClienteRepositoryVetor.getInstancia();
    }

    public void salvar(Cliente cliente) throws CpfInvalidoException {

        if (!CpfUtil.isCPF(cliente.getCpf())) {
            throw new CpfInvalidoException("o cpf " + cliente.getCpf() + " é invalido");
        }

        clienteRepository.salvar(cliente);
    }

    public Cliente buscar(String cpf) {
        return clienteRepository.buscar(cpf);
    }

}
