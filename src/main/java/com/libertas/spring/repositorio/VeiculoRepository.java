package com.libertas.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertas.exemplospring.pojo.Agendamento;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
