package br.edu.iftm.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iftm.query.domain.NotaFiscal;


@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    
    @Query("SELECT n FROM NotaFiscal n WHERE n.desconto = 0")
    List<NotaFiscal> findItemsSoldWithoutDiscount();

    @Query("SELECT n FROM NotaFiscal n WHERE n.desconto > 0")
    List<NotaFiscal> findItemsSoldWithDiscount();

    @Query("SELECT n FROM NotaFiscal n ORDER BY n.valor_unit DESC")
    List<NotaFiscal> findItemsOrderByValorUnitDesc();

    @Query("SELECT n.cod_prod, SUM(n.quantidade) as total FROM NotaFiscal n GROUP BY n.cod_prod ORDER BY total DESC")
    List<Object[]> findTopSellingProduct();

    @Query("SELECT n FROM NotaFiscal n WHERE n.quantidade > 10")
    List<NotaFiscal> findNFWithMoreThan10UnitsSold();

    @Query("SELECT n.id_nf, SUM(n.valor_unit * n.quantidade) as total FROM NotaFiscal n GROUP BY n.id_nf HAVING SUM(n.valor_unit * n.quantidade) > 500 ORDER BY SUM(n.valor_unit * n.quantidade) DESC")
    List<Object[]> findTotalNFValueGreaterThan500OrderByDesc();
}
