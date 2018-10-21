package com.klostur.prodavnica.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klostur.prodavnica.entities.user.SecurityUser;


@Repository
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);
}
