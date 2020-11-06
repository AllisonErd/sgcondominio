package br.com.gna.sgcondominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gna.sgcondominio.entities.ImovelEntity;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelEntity, Integer>{

}
