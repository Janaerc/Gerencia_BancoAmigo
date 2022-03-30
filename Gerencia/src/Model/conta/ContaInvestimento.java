/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.conta;

import Model.cliente.Cliente;

/**
 *
 * @author dell
 */
public class ContaInvestimento extends Conta{
    
    private double depositoMinimo;
    private double montanteMinimo;
    
    public ContaInvestimento(Cliente cliente,int num, double saldo, double depositoini,double depositoMin, double montanteMin) {
        super(cliente, num, saldo, depositoini);
        this.depositoMinimo = depositoMin;
        this.montanteMinimo = montanteMin;
    }
    
@Override
    public boolean deposita(double valor){
        if(valor >= depositoMinimo){
            super.deposita(valor);
            return true;
        }else{
            throw new RuntimeException("O valor é menor que o permitido!!");
        }
        
    }
    
@Override
    public boolean saca(double valor){
        if(valor >= montanteMinimo){
            try{
                super.saca(valor);
                return true;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }else{
            throw new RuntimeException("O valor é menor que o permitido para o saque!!");
        }        
    }
    
@Override
    public void remunera(){
        super.deposita(this.getSaldo()*0.02);
    }
}
