package br.jbenevides.meli.springapp.service;

import br.jbenevides.meli.springapp.dto.CountAllUsersDTO;
import br.jbenevides.meli.springapp.dto.UserDetailsDTO;
import br.jbenevides.meli.springapp.model.UserDetails;
import br.jbenevides.meli.springapp.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService implements IUserDetailsService {

    @Autowired
    private UserDetailsRepo repo;

    public UserDetails insert(UserDetailsDTO userDetails) {
        Optional<UserDetails> userDetailsByEmail = repo.findByEmail(userDetails.getEmail());
        if (userDetailsByEmail.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email not found");
        }
        UserDetails newUserDetails = new UserDetails(userDetails);
        return repo.save(newUserDetails);
    }

    @Override
    public List<UserDetails> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UserDetails> getById(long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public CountAllUsersDTO countAll() {
        List<UserDetails> userDetailsList = repo.findAll();
        return new CountAllUsersDTO(userDetailsList, (long) userDetailsList.size());
    }


}
