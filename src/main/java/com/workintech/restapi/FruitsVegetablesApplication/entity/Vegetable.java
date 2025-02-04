package com.workintech.restapi.FruitsVegetablesApplication.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vegetable" , schema = "vegetables")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;


    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
