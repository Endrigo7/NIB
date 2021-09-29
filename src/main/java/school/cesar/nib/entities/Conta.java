package school.cesar.nib.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    private String numero;
    private double saldo;
    private String senha;

    public void creditar(double valor){
        saldo += valor;
    }

    public void debitar(double valor){
        saldo -= valor;
    }

    //TODO fazer o transferir.
}
