package school.cesar.nib.guis;

import school.cesar.nib.entities.Cliente;
import school.cesar.nib.exceptions.CpfInvalidoException;
import school.cesar.nib.services.ClienteService;

import java.util.Scanner;

public class ClienteGui {

    private ClienteService clienteService;

    public ClienteGui() {
        clienteService = new ClienteService();
    }

    public void exibeMenu(Scanner leTeclado) {
        int opcaoMenu = 0;

        do {
            System.out.println("Selecione a opção desejada");
            System.out.println(" 1 - Cadastrar Cliente");
            System.out.println(" 2 - Consultar Cliente");
            System.out.println(" 3 - Sair");

            opcaoMenu = leTeclado.nextInt();

            switch (opcaoMenu) {
                case 1:
                    salvar(leTeclado);
                    break;
                case 2:
                    buscar(leTeclado);
                    break;
                case 3:
                    break;
            }

        } while (opcaoMenu != 3);

    }

    private void salvar(Scanner leTeclado) {
        System.out.println("Digite o cpf do cliente");
        String cpf = leTeclado.next();

        System.out.println("Digite o nome do Cliente");
        String nome = leTeclado.next();

        Cliente cliente = new Cliente(cpf, nome);

        try {
            clienteService.salvar(cliente);
            System.out.println("O cliente foi cadastrado com sucesso");
        } catch (CpfInvalidoException e) {
            System.out.println("Erro ao cadastrar cliente. " + e.getMessage());
        }
    }

    private void buscar(Scanner leTeclado) {
        System.out.println("Digite o cpf");
        String cpf = leTeclado.next();

        Cliente cliente = clienteService.buscar(cpf);
        if (cliente == null) {
            System.out.println("Cpf não encontrado");
        } else {
            System.out.println("Cliente: " + cliente);
        }
    }
}
