package com.springboot.workers.jdbcexample.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.repository.WorkerRepository;
@RestController
@RequestMapping("/worker")
public class WorkerController {

 @Autowired
private WorkerRepository workerRepository;

 @GetMapping("/showWorker")
public Worker getWorker() {
try {
return workerRepository.getWorker(1);
}
catch(SQLException e)
{
System.out.println(e);
return null;
}
}
@GetMapping("/all/showWorkers")
public List<Worker> getWorkers(){
try {
return workerRepository.getWorkers();
}
catch(SQLException e)
{
System.out.println(e);
return null;
}
}
@GetMapping("/create")
public String create() throws SQLException {
workerRepository.add(new Worker(407, "Charani", "B", "ECE",500000.0, "charani7@gmail.com"));
return "Record Created Successfully";
}
@GetMapping("/update")
public String update() throws SQLException {
workerRepository.update(new Worker(407, "Charani", "B", "ECE",800000.0, "charani7@gmail.com"));
return "Record Updated Successfully";
}
@GetMapping("/delete")
public String delete() throws SQLException {
workerRepository.delete(1);
return "Record Deleted Successfully";
}
}