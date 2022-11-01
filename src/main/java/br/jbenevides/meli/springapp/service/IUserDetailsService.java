package br.jbenevides.meli.springapp.service;

import br.jbenevides.meli.springapp.dto.CountAllUsersDTO;
import br.jbenevides.meli.springapp.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserDetailsService {

    List<UserDetails> getAll();
    Optional<UserDetails> getById(long id);
    void deleteById (long id);
    CountAllUsersDTO countAll();

}
