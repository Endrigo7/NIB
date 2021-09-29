package school.cesar.nib.services;

import school.cesar.nib.entities.Cliente;
import school.cesar.nib.repositories.ClienteRepository;
import school.cesar.nib.util.CpfUtil;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(){
        clienteRepository = ClienteRepository.getInstancia();
    }

    public boolean salvar(Cliente cliente){

        if(!CpfUtil.isCPF(cliente.getCpf())){
            return false;
        }

        clienteRepository.salvar(cliente);
        return true;
    }

    public Cliente buscar(String cpf){
        return clienteRepository.buscar(cpf);
    }

}
