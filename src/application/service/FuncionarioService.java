package application.service;

import domain.funcionario.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class FuncionarioService {

    private final List<Funcionario> funcionarioList;

    public FuncionarioService(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioList;
    }

    public String demitirFuncionario(Funcionario funcionario) {
        funcionario.demitir();

        return "Funcionario demitido com sucesso!";
    }

    public void editarFuncioanario(UUID id, String nome, String cargo, BigDecimal salario) {
        for(Funcionario funcionario : funcionarioList) {
            if(funcionario.getId().equals(id)) {
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
            }
        }
    }

    public String cadastrarFuncionario(Funcionario funcionario) {
        if(funcionario == null) {
            throw new IllegalArgumentException("O funcionario nao pode ser nulo");
        }

        funcionarioList.add(funcionario);

        return "Funcionario adicionado com sucesso!";
    }

    public void realizarAumentoSalarial(UUID id, double aumento) {
        for(Funcionario funcionario : funcionarioList) {
            if(funcionario.getId().equals(id)) {
                BigDecimal salario = funcionario.getSalario();

                salario.multiply(BigDecimal.valueOf(aumento));

                funcionario.setSalario(salario);

                System.out.println("Funcionario editado com sucesso!");
            }
        }
    }


}
