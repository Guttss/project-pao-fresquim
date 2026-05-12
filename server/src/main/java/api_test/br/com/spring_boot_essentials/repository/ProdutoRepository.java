package api_test.br.com.spring_boot_essentials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api_test.br.com.spring_boot_essentials.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    boolean existsByCodigoBarras(String codigoBarras);

}
