package school.cesar.nib.services;

import school.cesar.nib.entities.Cliente;
import school.cesar.nib.entities.Conta;
import school.cesar.nib.repositories.ClienteRepository;
import school.cesar.nib.repositories.ContaRepository;
import school.cesar.nib.util.CpfUtil;
import school.cesar.nib.util.SenhaUtil;

public class ContaService {

    private static final double MENOR_VALOR_DEPOSITO_INICIAL = 200;

    private ContaRepository contaRepository;
    private ClienteRepository clienteRepository;

    public ContaService(){
        contaRepository = ContaRepository.getInstancia();
        clienteRepository = ClienteRepository.getInstancia();
    }

    public Conta salvar(String cpf, double valorInicial, String senha, String confirmacaoSenha){
        if(!CpfUtil.isCPF(cpf)){
            return null;
        }

        if(valorInicial < MENOR_VALOR_DEPOSITO_INICIAL){
            return null;
        }

        if(!senha.equals(confirmacaoSenha) ){
            return null;
        }

        Cliente cliente = clienteRepository.buscar(cpf);
        if(cliente == null){
            return null;
        }

        String senhaCriptografada = SenhaUtil.criptografa(senha);

        Conta conta = new Conta();
        conta.gerarNumero();
        conta.setCliente(cliente);
        conta.setSaldo(valorInicial);
        conta.setSenha(senhaCriptografada);

        contaRepository.salvar(conta);

        return conta;
    }

    public Conta buscar(String numero){
        return contaRepository.buscar(numero);
    }
    
    public boolean debitar(String numero, String senha, double valor){

        Conta conta = getContaPorNumeroESenha(numero, senha);
        if (conta == null) return false;

        if(conta.getSaldo() < valor){
            return false;
        }

        conta.debitar(valor);
        return true;
    }

    private Conta getContaPorNumeroESenha(String numero, String senha) {
        Conta conta = buscar(numero);

        if(conta == null || !conta.getSenha().equals(senha)){
            return null;
        }
        return conta;
    }
}
