package domain.vendaprato.model;

import domain.prato.model.Prato;
import domain.vendaprato.exception.QuantidadeInvalidaException;

import java.math.BigDecimal;
import java.util.UUID;

public class VendaPrato {
    private final UUID id;
    private final Prato prato;
    private final int quantidade;
    private final BigDecimal precoBase;

    private VendaPrato(UUID id, Prato prato,int quantidade, BigDecimal precoBase) {
        this.id = id;
        this.prato = prato;
        this.quantidade = quantidade;
        this.precoBase = precoBase;
    }

    public static VendaPrato criar(Prato prato,
                            int quantidade) {

        if(prato.getEstoque() < quantidade) {
            throw new QuantidadeInvalidaException("Quantidade invalida");
        }

        prato.setEstoque(prato.getEstoque() - quantidade);

        return new VendaPrato(
                UUID.randomUUID(),
                prato,
                quantidade,
                prato.getPreco()
                        .multiply(BigDecimal.valueOf(quantidade))
        );
    }


    public UUID getId() {
        return id;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }
}
