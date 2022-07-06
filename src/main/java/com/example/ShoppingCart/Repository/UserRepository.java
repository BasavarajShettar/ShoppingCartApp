package com.example.ShoppingCart.Repository;

import javax.transaction.Transactional;

import com.example.ShoppingCart.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

}
