package br.com.senai.domain.model;

import br.com.senai.domain.ValidationGroups;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class Aluno {

    @NotNull(groups = ValidationGroups.ClienteId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 14)
    private String telefone;

}
