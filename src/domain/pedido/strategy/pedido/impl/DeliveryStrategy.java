package domain.pedido.strategy.pedido.impl;

import domain.pedido.model.PedidoTipo;
import domain.pedido.strategy.pedido.PedidoStrategy;

import java.math.BigDecimal;

public class DeliveryStrategy implements PedidoStrategy {

    private static final BigDecimal DELIVERY_FRETE = new BigDecimal(15.0);

    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PedidoTipo pedidoTipo) {
        return valorTotal.add(DELIVERY_FRETE);
    }
}
