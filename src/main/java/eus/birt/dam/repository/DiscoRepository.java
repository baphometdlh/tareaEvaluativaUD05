package eus.birt.dam.repository;

import eus.birt.dam.domain.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscoRepository extends JpaRepository<Disco, Integer> {
}
