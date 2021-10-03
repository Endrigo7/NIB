package school.cesar.nib.services;

import school.cesar.nib.entities.Cliente;
import school.cesar.nib.entities.Conta;
import school.cesar.nib.entities.ContaSuperBonificada;
import school.cesar.nib.exceptions.ClienteNaoCadastradoException;
import school.cesar.nib.exceptions.ContaInvalidaException;
import school.cesar.nib.exceptions.CpfInvalidoException;
import school.cesar.nib.exceptions.SaldoInvalidoException;
import school.cesar.nib.repositories.ClienteRepositoryArrayList;
import school.cesar.nib.repositories.ContaRepositoryArrayList;
import school.cesar.nib.util.CpfUtil;
import school.cesar.nib.util.SenhaUtil;

public class ContaService {

    private static final double MENOR_VALOR_DEPOSITO_INICIAL = 200;

    private ContaRepositoryArrayList contaRepositoryArrayList;
    private ClienteRepositoryArrayList clienteRepositoryArrayList;

    public ContaService() {
        contaRepositoryArrayList = ContaRepositoryArrayList.getInstancia();
        clienteRepositoryArrayList = ClienteRepositoryArrayList.getInstancia();
    }

    public Conta salvar(Conta conta) {
        contaRepositoryArrayList.salvar(conta);
        return conta;
    }

    public Conta salvar(String cpf, double valorInicial, String senha, String confirmacaoSenha)
            throws ContaInvalidaException, CpfInvalidoException, ClienteNaoCadastradoException {
        return salvar(cpf, valorInicial, senha, confirmacaoSenha, null);
    }

    public Conta salvar(String cpf, double valorInicial, String senha, String confirmacaoSenha, String rg)
            throws ContaInvalidaException, CpfInvalidoException, ClienteNaoCadastradoException {

        if (rg != null) {
            throw new ContaInvalidaException("RG informado é invalido");
        }

        if (!CpfUtil.isCPF(cpf)) {
            throw new CpfInvalidoException("O CPF " + cpf + " é invalido");
        }

        if (valorInicial < MENOR_VALOR_DEPOSITO_INICIAL) {
            throw new SaldoInvalidoException("O valor inicial deve ser ao menos " + MENOR_VALOR_DEPOSITO_INICIAL);
        }

        if (!senha.equals(confirmacaoSenha)) {
            throw new ContaInvalidaException("A senha deve ser igual a confirmação da senha!");
        }

        Cliente cliente = clienteRepositoryArrayList.buscar(cpf);
        if (cliente == null) {
            throw new ClienteNaoCadastradoException("O CLiente com CPF " + cpf + " não foi encontrado na base de dados");
        }

        String senhaCriptografada = SenhaUtil.criptografa(senha);

        Conta conta = new ContaSuperBonificada();
        conta.gerarNumero();
        conta.setCliente(cliente);
        conta.setSaldo(valorInicial);
        conta.setSenha(senhaCriptografada);

        return salvar(conta);
    }

    public Conta buscar(String numero) {
        return contaRepositoryArrayList.buscar(numero);
    }

    public boolean debitar(String numero, String senha, double valor) {

        Conta conta = getContaPorNumeroESenha(numero, senha);
        if (conta == null) return false;

        if (conta.getSaldo() < valor) {
            return false;
        }

        conta.debitar(valor);
        return true;
    }

    private Conta getContaPorNumeroESenha(String numero, String senha) {
        Conta conta = buscar(numero);

        if (conta == null || !conta.getSenha().equals(senha)) {
            return null;
        }
        return conta;
    }
}
