package com.dcankayrak.OnlineClub.repository;

import com.dcankayrak.OnlineClub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
