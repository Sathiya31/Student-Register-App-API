package com.sathiyapriyan;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	Optional<Student> findOne(int rollNo);
}
