package domain.pedido.strategy.pagamento.impl;

import domain.pedido.model.PagamentoTipo;
import domain.pedido.strategy.pagamento.PagamentoStrategy;

import java.math.BigDecimal;

public class EspecieStrategy implements PagamentoStrategy {

    private static final BigDecimal ESPECIE_TAXA = new BigDecimal(0.92);

    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PagamentoTipo pagamentoTipo) {
        return valorTotal.multiply(ESPECIE_TAXA);
    }
}
