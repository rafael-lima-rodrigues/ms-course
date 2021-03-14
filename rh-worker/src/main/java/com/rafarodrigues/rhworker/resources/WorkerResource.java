package com.rafarodrigues.rhworker.resources;

import com.rafarodrigues.rhworker.entities.Worker;
import com.rafarodrigues.rhworker.repositories.WorkerRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = repository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findbyId(@PathVariable Long id) throws NotFoundException {

       /* try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        logger.info("PORT = " + env.getProperty("local.server.port"));
        Worker worker = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("worker not found"));
        return ResponseEntity.ok(worker);
    }
}
