package school.cesar.nib.entities;

import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    @Test
    public void deveIncrementarOSaldoEm20QuandoValorFor20(){
        Conta conta = new Conta();
        conta.creditar(20);
        Assert.assertEquals(120.0, conta.getSaldo(), 0);
    }

}
