package co.ao.mfdesenvolvimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ao.mfdesenvolvimento.domain.Cidade;
import co.ao.mfdesenvolvimento.domain.Producto;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
