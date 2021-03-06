package com.hotelMS.repository;

import com.hotelMS.domain.User;
import com.hotelMS.dto.user.CompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.companyId = ?1 ")
    User getAllBy(CompanyDto companyDto);

    User findByToken(String token);
}
