package com.example.data.jpa.repository;


import com.example.data.jpa.entity.Student;

public interface UserRepository extends BaseRepository<Student,Integer>{

    Student findByUsernameOrderByCreateTimeDesc(String username);

}
