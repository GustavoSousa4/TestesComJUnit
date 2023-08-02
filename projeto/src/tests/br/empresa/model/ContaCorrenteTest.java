package br.empresa.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {

    private final ContaCorrente CONTA_CORRENTE = new ContaCorrente(4889, 32568);

    @Test
    public void depositarValorMaiorQueZero_ExpectedValorDepositado(){
        CONTA_CORRENTE.depositar(500.0);
        assertEquals(500.0, CONTA_CORRENTE.getSaldo());
    }

    @Test
    public void depositarValorIgualZero_ExpectedException()throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class,()-> CONTA_CORRENTE.depositar(0.0));
    }

    @Test
    public void retirarDeSaldoZerado_ExpectedFalse() {
        assertEquals(false, CONTA_CORRENTE.retirar(250.0));
    }
    @Test
    public void retirarValorDeSaldo_ExpectedTrue() {
        CONTA_CORRENTE.depositar(500.0);
        assertEquals(true, CONTA_CORRENTE.retirar(250));
    }

    @Test
    public void retirarValorIgualZero_ExpectedException()throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class,()-> CONTA_CORRENTE.retirar(0.0));
    }

    @Test
    public void transferirValorMaiorQueSaldo_ExpctedFalse(){
        assertEquals(false,CONTA_CORRENTE.transferirPara(new ContaCorrente(5567,47855),50.0));
    }
    @Test
    public void transferirValor_ExpectedTrue(){
        CONTA_CORRENTE.depositar(150.0);
        assertEquals(true, CONTA_CORRENTE.transferirPara(new ContaCorrente(1234,2789),50.0));
    }
}