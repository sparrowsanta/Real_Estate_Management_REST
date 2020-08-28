package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@Table(name = "client")
public class Client extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @Min(18)
    private int age;
    @Email
    private String email;
    private String city;
    private String street;

//    private String flatNumber;

    public Client() {
    }

    public Client(long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
