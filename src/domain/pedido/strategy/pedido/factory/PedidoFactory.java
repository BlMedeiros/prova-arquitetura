package domain.pedido.strategy.pedido.factory;

import domain.pedido.exception.PedidoInvalidoException;
import domain.pedido.model.PedidoTipo;
import domain.pedido.strategy.pedido.PedidoStrategy;
import domain.pedido.strategy.pedido.impl.DeliveryStrategy;
import domain.pedido.strategy.pedido.impl.RetiradaStrategy;

public class PedidoFactory {

    public static PedidoStrategy get(PedidoTipo pedidoTipo) {

        if(pedidoTipo == null) {
            throw new PedidoInvalidoException("Tipo de transação não pode ser nulo");
        }

        return switch (pedidoTipo) {
            case DELIVERY -> new DeliveryStrategy();
            case RETIRADA -> new RetiradaStrategy();

            default -> throw new PedidoInvalidoException("Tipo de transação inválido");
        };
    }
}
