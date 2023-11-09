package br.edu.ifce.TimetableScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifce.TimetableScheduler.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {

}
