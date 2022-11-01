package br.jbenevides.meli.springapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {

    @NotEmpty
    @Size(max = 150, min = 3)
    private String name;

    @NotEmpty
    @Size(max = 150)
    @Email(message = "Invalid e-email.")
    private String email;

}
