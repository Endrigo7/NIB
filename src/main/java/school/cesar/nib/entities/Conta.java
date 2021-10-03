package school.cesar.nib.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Conta {

    private Cliente cliente;
    private String numero;
    private double saldo;
    private String senha;

    public void gerarNumero(){
        LocalDateTime now = LocalDateTime.now();
        numero = String.valueOf(now.getYear())
                + String.valueOf(now.getMonth())
                + String.valueOf(now.getDayOfMonth())
                + String.valueOf(now.getHour())
                + String.valueOf(now.getMinute())
                + String.valueOf(now.getSecond())
                + String.valueOf(now.getNano())
                + "-"
                + new Random(99).nextInt();
    }

    public void creditar(double valor){
        saldo += valor;
    }

    public void debitar(double valor){
        saldo -= valor;
    }

    public double exibirSaldo(){
        return  getSaldo();
    }

    public abstract void renderJuros();

    //TODO fazer o transferir.
}
