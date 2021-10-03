package school.cesar.nib.guis;

import school.cesar.nib.entities.Conta;
import school.cesar.nib.exceptions.ClienteNaoCadastradoException;
import school.cesar.nib.exceptions.ContaInvalidaException;
import school.cesar.nib.exceptions.CpfInvalidoException;
import school.cesar.nib.services.ContaService;

import java.util.Scanner;

public class ContaGui {

    private ContaService contaService;

    public ContaGui() {
        contaService = new ContaService();
    }

    public void exibeMenu(Scanner leTeclado) {
        int opcaoMenu = 0;

        do {
            System.out.println("Selecione a opção desejada");
            System.out.println(" 1 - Criar conta");
            System.out.println(" 2 - Consultar conta");
            System.out.println(" 3 - Debitar");
            System.out.println(" 4 - Sair");

            opcaoMenu = leTeclado.nextInt();

            switch (opcaoMenu) {
                case 1:
                    salvar(leTeclado);
                    break;
                case 2:
                    exibirConta(leTeclado);
                    break;
                case 3:
                    debitar(leTeclado);
                    break;
                case 4:
                    break;
            }
        } while (opcaoMenu != 4);
    }

    private void salvar(Scanner leTeclado) {
        System.out.println("Digite o CPF do Cliente");
        String cpf = leTeclado.next();

        System.out.println("Digite o valor do deposito inicial");
        double valorInicial = leTeclado.nextDouble();

        System.out.println("Digite a senha");
        String senha = leTeclado.next();

        System.out.println("Digite novamente a senha para confirmar");
        String confirmacaoSenha = leTeclado.next();

        try {
            Conta conta = contaService.salvar(cpf, valorInicial, senha, confirmacaoSenha);
            System.out.println("Conta " + conta + " criada com sucesso.");
        } catch (CpfInvalidoException | ContaInvalidaException e) {
            System.out.println("Erro ao cadastradar a conta. " + e.getMessage());
        } catch (ClienteNaoCadastradoException e) {
            System.out.println("Erro ao cadastradar a conta. " + e.getMessage());
            System.out.println("Para cadastrar um cliente voce deve seguir os seguintes passos");
            System.out.println("selecione a opcao 1 no menu");
            System.out.println("faca isso isso e isso");
        }

    }

    private void exibirConta(Scanner leTeclado) {
        System.out.println("Digite o numero da conta");
        String numero = leTeclado.next();

        Conta conta = contaService.buscar(numero);
        if (conta == null) {
            System.out.println("conta de numero " + numero + " não encontrada");
        } else {
            System.out.println("conta: " + conta);
        }
    }

    private void debitar(Scanner leTeclado) {
        System.out.println("Digite o numero da Conta");
        String numero = leTeclado.next();

        System.out.println("Digite a senha");
        String senha = leTeclado.next();

        System.out.println("Digite o valor");
        double valor = leTeclado.nextDouble();

        if (contaService.debitar(numero, senha, valor)) {
            System.out.println("deu bom ");
        } else {
            System.out.println("deu ruim ");
        }
    }
}
