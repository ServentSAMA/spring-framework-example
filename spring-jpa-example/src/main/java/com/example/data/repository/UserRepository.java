package com.example.data.repository;


import com.example.data.entity.Student;

public interface UserRepository extends BaseRepository<Student,Integer>{

    Student findByUsernameOrderByCreateTimeDesc(String username);

}
