package domain.pedido.model;

import domain.vendaprato.model.VendaPrato;
import domain.pedido.strategy.pagamento.PagamentoStrategy;
import domain.pedido.strategy.pedido.PedidoStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private final UUID id;
    private final List<VendaPrato> vendaPratoList;
    private final PedidoTipo pedidoTipo;
    private final PagamentoTipo pagamentoTipo;
    private final BigDecimal valorTotal;
    private final BigDecimal valorFinal;

    private Pedido(UUID id, List<VendaPrato> vendaPratoList, PedidoTipo pedidoTipo, PagamentoTipo pagamentoTipo, BigDecimal valorTotal, BigDecimal valorFinal) {
        this.id = id;
        this.vendaPratoList = vendaPratoList;
        this.pedidoTipo = pedidoTipo;
        this.pagamentoTipo = pagamentoTipo;
        this.valorTotal = valorTotal;
        this.valorFinal = valorFinal;
    }

    public static Pedido criar(List<VendaPrato> vendaPratoList,
                               PedidoTipo pedidoTipo,
                               PedidoStrategy pedidoStrategy,
                               PagamentoTipo pagamentoTipo,
                               PagamentoStrategy pagamentoStrategy) {

        BigDecimal valorTotal = new BigDecimal("0.0");

        vendaPratoList.forEach(vendaPrato -> valorTotal.add(vendaPrato.getPrecoBase()));

        BigDecimal valorFinal = pagamentoStrategy.calcular(valorTotal,pagamentoTipo);

        valorFinal.add(pedidoStrategy.calcular(valorTotal,pedidoTipo));

        return new Pedido(
                UUID.randomUUID(),
                vendaPratoList,
                pedidoTipo,
                pagamentoTipo,
                valorTotal,
                valorFinal
        );


    }


}
