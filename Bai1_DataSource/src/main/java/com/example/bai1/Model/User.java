package com.example.bai1.Model;

import com.example.bai1.Model.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Builder
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    private String email;
    private String password;
    private String birthday;
    private Gender gender;
}
