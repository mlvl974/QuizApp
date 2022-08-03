package com.ncs.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;





import com.ncs.student.model.User;




public interface StudentRepository extends JpaRepository<User, Integer>{

}
