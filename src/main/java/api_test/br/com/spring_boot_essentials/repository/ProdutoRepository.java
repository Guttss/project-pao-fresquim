package api_test.br.com.spring_boot_essentials.repository;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
}
