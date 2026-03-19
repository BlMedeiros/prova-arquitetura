package domain.pedido.strategy.pagamento;

import domain.pedido.model.PagamentoTipo;

import java.math.BigDecimal;

public interface PagamentoStrategy {
    BigDecimal calcular(BigDecimal valorTotal, PagamentoTipo pagamentoTipoTipo);

}
