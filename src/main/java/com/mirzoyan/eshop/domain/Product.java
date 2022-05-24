package com.mirzoyan.eshop.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = {"hs_code"}))
public class Product {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    private Integer id;

    @NotNull
    @Column(name = "hs_code")
    String hsCode;

    @NotNull
    @Column(name = "name")
    String name;

    @NotNull
    @Column(name = "description")
    String description;

    @NotNull
    @Column(name = "cmp_name")
    String companyName;

    @Column(name = "calorie")
    Integer calorie;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "mass")
    Integer mass;

    @NotNull
    @Column(name = "country")
    String country;

    @NotNull
    @Column(name = "dov")
    LocalDate validFrom;

    @NotNull
    @Column(name = "eov")
    LocalDate validTo;
}
