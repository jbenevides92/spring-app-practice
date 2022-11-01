package br.jbenevides.meli.springapp.model;

import br.jbenevides.meli.springapp.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(name = "e_mail", length = 100, unique = true)
    private String email;

    public UserDetails(UserDetailsDTO userDetails) {
        this.name = userDetails.getName();
        this.email = userDetails.getEmail();
    }
}
