package br.empresa.model;

public interface ContaBancaria {

    double getSaldo();

    boolean retirar(double valor);

    void depositar(double valor);

    boolean transferirPara(ContaBancaria destino, double valor);
}
