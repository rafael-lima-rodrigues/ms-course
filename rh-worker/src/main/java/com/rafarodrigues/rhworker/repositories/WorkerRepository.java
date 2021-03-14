package com.rafarodrigues.rhworker.repositories;

import com.rafarodrigues.rhworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
