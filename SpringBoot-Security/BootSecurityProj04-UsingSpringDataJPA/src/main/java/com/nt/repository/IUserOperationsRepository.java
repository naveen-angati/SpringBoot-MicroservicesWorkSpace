package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.UsersInfo;

public interface IUserOperationsRepository extends JpaRepository<UsersInfo, Integer>{
         public   UsersInfo   findByUname(String  user);
}
