package br.com.alura.rh.regra_de_negocio;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidaReajusteSalarial {
    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.40")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        funcionario.aplicaReajuste(aumento);
    }

}
