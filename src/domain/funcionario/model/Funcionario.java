package domain.funcionario.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Funcionario {
    private final UUID id;
    private String nome;
    private String cargo;
    private BigDecimal salario;
    private boolean efetivado;

    public Funcionario(String nome, String cargo, BigDecimal salario) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.efetivado = true;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isEfetivado() {
        return efetivado;
    }

    public void setEfetivado(boolean efetivado) {
        this.efetivado = efetivado;
    }

    public void demitir() {
        this.efetivado = false;
    }
}
