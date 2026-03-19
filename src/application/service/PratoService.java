package application.service;

import domain.prato.model.Prato;
import domain.vendaprato.model.VendaPrato;

import java.util.List;
import java.util.UUID;

public class PratoService {

    private final List<Prato> pratoList;

    public PratoService(List<Prato> pratoList) {
        this.pratoList = pratoList;
    }

    public String cadastrarPrato(Prato prato) {
        pratoList.add(prato);

        return "Prato cadastrado com sucesso!";
    }

    public void adicionarEstoque(UUID id,int quantidade) {
        for(Prato prato : pratoList) {
            int estoquePrato = prato.getEstoque();

            estoquePrato += quantidade;

            prato.setEstoque(estoquePrato);
        }
    }

    public VendaPrato cadastrarVenda(Prato prato, int quantidade) {
        return VendaPrato.criar(prato,quantidade);
    }
}
