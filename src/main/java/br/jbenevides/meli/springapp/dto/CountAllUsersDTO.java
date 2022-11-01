package br.jbenevides.meli.springapp.dto;

import br.jbenevides.meli.springapp.model.UserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CountAllUsersDTO {

    private List<UserDetails> userDetailsList;

    @NotNull
    private Long total;

    public CountAllUsersDTO(List<UserDetails> userDetailsList, Long total) {
        this.userDetailsList = userDetailsList;
        this.total = total;
    }
}
