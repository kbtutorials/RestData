package com.restdata.controller;

import com.restdata.entities.Student;
import com.restdata.model.Status;
import com.restdata.model.StudentResponse;
import com.restdata.repo.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mock")
@AllArgsConstructor
public class StudentRestController {
    private final StudentRepo studentRepo;
    @GetMapping(value="/getStudents")
    private ResponseEntity<StudentResponse> getStudents(){
        List<Student> allStudents = studentRepo.findAll();
        Status status = new Status();
        status.setStatuscode(200);
        status.setStatusMessage("SUCCESS");
        StudentResponse s = new StudentResponse();
        s.setResponse(allStudents);
        s.setStatus(status);
        return  ResponseEntity.ok().body(s);

    }
    @PostMapping("/addStudent")
    private ResponseEntity<Student> addStudet(@RequestBody Student student){
        Student save = studentRepo.save(student);
        return ResponseEntity.ok().body(save);

    }

    @DeleteMapping(value = "/deleteStudent/{name}")
    public void deleteStudent(@PathVariable("name") String name){
        Optional<Student> byName = studentRepo.findByName(name);
        if(byName.isPresent()){
            studentRepo.delete(byName.get());
        }
    }
@PutMapping(value="/updateStudentInfo/{id}")
    public ResponseEntity<Student> updateStudentInfo(@PathVariable("id") Long id,@RequestBody Student student){
    Optional<Student> byId = studentRepo.findById(id);
    if(byId.isPresent()){
        Student exsitingStudent = byId.get();
        exsitingStudent = getStudent(exsitingStudent,student);
        return ResponseEntity.ok().body(exsitingStudent);
       }else{
        Student newStudent = new Student();
       newStudent =getStudent(newStudent,student);
        return ResponseEntity.ok().body(newStudent);
    }

}

private Student getStudent(Student s,Student s1){
       s.setName(s1.getName());
       s.setAddress(s1.getAddress());
       s.setHobby(s1.getHobby());
    Student save = studentRepo.save(s);
    return save;
}


}
