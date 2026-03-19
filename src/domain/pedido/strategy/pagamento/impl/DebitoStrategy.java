package domain.pedido.strategy.pagamento.impl;

import domain.pedido.model.PagamentoTipo;
import domain.pedido.strategy.pagamento.PagamentoStrategy;

import java.math.BigDecimal;

public class DebitoStrategy implements PagamentoStrategy {

    private static final BigDecimal DEBITO_TAXA = new BigDecimal(1);

    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PagamentoTipo pagamentoTipo) {
        return valorTotal.multiply(DEBITO_TAXA);
    }
}
