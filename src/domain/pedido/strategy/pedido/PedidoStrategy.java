package domain.pedido.strategy.pedido;

import domain.pedido.model.PedidoTipo;

import java.math.BigDecimal;

public interface PedidoStrategy {
    BigDecimal calcular(BigDecimal valorTotal, PedidoTipo pedidoTipo);
}
