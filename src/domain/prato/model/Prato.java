package domain.prato.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Prato {
    private final UUID id;
    private String nome;
    private BigDecimal preco;
    private int estoque;

    public Prato(UUID id, String nome, BigDecimal preco, int estoque) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
