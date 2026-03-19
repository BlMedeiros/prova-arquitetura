package domain.pedido.strategy.pagamento.impl;

import domain.pedido.model.PagamentoTipo;
import domain.pedido.strategy.pagamento.PagamentoStrategy;

import java.math.BigDecimal;

public class CreditoStrategy implements PagamentoStrategy {

    private static final BigDecimal CREDITO_TAXA = new BigDecimal(1.05);

    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PagamentoTipo pagamentoTipo) {
        return valorTotal.multiply(CREDITO_TAXA);
    }
}
