package br.jbenevides.meli.springapp.controller;

import br.jbenevides.meli.springapp.dto.CountAllUsersDTO;
import br.jbenevides.meli.springapp.dto.UserDetailsDTO;
import br.jbenevides.meli.springapp.model.UserDetails;
import br.jbenevides.meli.springapp.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserDetailsController {

    @Autowired
    private UserDetailsService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDetails> insertNewUser(@RequestBody UserDetailsDTO userDetails) {
        UserDetails newUser = service.insert(userDetails);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetails>> getAll() {
        List<UserDetails> userDetailsList = service.getAll();
        return new ResponseEntity<>(userDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getById(@PathVariable long id) {
        Optional<UserDetails> userDetailsId = service.getById(id);
        return new ResponseEntity<>(userDetailsId.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/quantity")
    public ResponseEntity<CountAllUsersDTO> getCount() {
        CountAllUsersDTO countAllUsersDTO = service.countAll();
        return new ResponseEntity<>(countAllUsersDTO, HttpStatus.OK);
    }


}
