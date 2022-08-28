package com.bank.person3.models.documents;

import com.bank.person3.models.enums.PersonGenre;
import com.bank.person3.models.utils.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person extends Audit implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private PersonGenre genre;
    private String documentId;
    private String phoneNumber;
    private String email;
}
