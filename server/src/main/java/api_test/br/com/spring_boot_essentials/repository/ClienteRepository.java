package api_test.br.com.spring_boot_essentials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api_test.br.com.spring_boot_essentials.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    boolean existsByCpf(String cpf); // Verifica se um cliente com o CPF fornecido já existe no banco de dados
}
