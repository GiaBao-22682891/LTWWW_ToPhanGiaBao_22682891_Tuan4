package org.example.bai1_jpa.Model;


import jakarta.persistence.*;
import lombok.*;
import org.example.bai1_jpa.Model.Enum.Gender;

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
