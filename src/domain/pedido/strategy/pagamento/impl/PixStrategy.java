package domain.pedido.strategy.pagamento.impl;

import domain.pedido.model.PagamentoTipo;
import domain.pedido.strategy.pagamento.PagamentoStrategy;

import java.math.BigDecimal;

public class PixStrategy implements PagamentoStrategy {

    private static final BigDecimal PIX_TAXA = new BigDecimal(0.90);


    @Override
    public BigDecimal calcular(BigDecimal valorTotal, PagamentoTipo pagamentoTipo) {
        return valorTotal.multiply(PIX_TAXA);
    }
}
