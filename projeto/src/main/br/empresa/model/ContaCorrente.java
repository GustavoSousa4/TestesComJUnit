package br.empresa.model;

public class ContaCorrente implements ContaBancaria {

    private int numeroAgencia;
    private int numeroContaCorrente;
    private double saldo;

    public ContaCorrente(int numeroAgencia, int numeroContaCorrente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroContaCorrente = numeroContaCorrente;
        this.saldo = 0.0;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor <= 0.0) {
            throw new IllegalArgumentException("O valor a ser retirado da conta corrente não pode ser menor ou igual à zero.");
        }
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a ser depositado na conta corrente não pode ser menor ou igual à zero.");
        }
        saldo += valor;
    }

    @Override
    public boolean transferirPara(ContaBancaria destino, double valor) {
        if (!retirar(valor)) {
            return false;
        }
        destino.depositar(valor);
        return true;
    }
}
