package domain.pedido.strategy.pagamento.factory;

import domain.pedido.exception.PagamentoInvalidoException;
import domain.pedido.model.PagamentoTipo;
import domain.pedido.strategy.pagamento.PagamentoStrategy;
import domain.pedido.strategy.pagamento.impl.CreditoStrategy;
import domain.pedido.strategy.pagamento.impl.DebitoStrategy;
import domain.pedido.strategy.pagamento.impl.EspecieStrategy;
import domain.pedido.strategy.pagamento.impl.PixStrategy;

public class PagamentoFactory {

    public static final PagamentoStrategy get(PagamentoTipo pagamentoTipo) {

        if(pagamentoTipo == null) {
            throw new PagamentoInvalidoException("Tipo de pagamento nulo");
        }

        return switch (pagamentoTipo) {
            case PIX -> new PixStrategy();
            case DEBITO -> new DebitoStrategy();
            case CREDITO -> new CreditoStrategy();
            case ESPECIE -> new EspecieStrategy();

            default -> throw new PagamentoInvalidoException("Tipo de pagamento inválido");
        };
    }
}
