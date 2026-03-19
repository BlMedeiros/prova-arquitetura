package domain.pedido.strategy.pedido.impl;

import domain.pedido.model.PedidoTipo;
import domain.pedido.strategy.pedido.PedidoStrategy;

import java.math.BigDecimal;

public class RetiradaStrategy implements PedidoStrategy {

    private static final BigDecimal RETIRADA_FRETE = new BigDecimal(2.0);

    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PedidoTipo pedidoTipo) {
        return valorTotal.add(RETIRADA_FRETE);
    }
}
