package com.restdata.model;

import com.restdata.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentResponse {
    List<Student> response;
    Status status;
}
