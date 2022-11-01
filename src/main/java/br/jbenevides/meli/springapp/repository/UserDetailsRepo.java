package br.jbenevides.meli.springapp.repository;

import br.jbenevides.meli.springapp.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

    List<UserDetails> findAll();
    Optional<UserDetails> findByEmail(String email);
    Optional<UserDetails> findById(long id);


}
