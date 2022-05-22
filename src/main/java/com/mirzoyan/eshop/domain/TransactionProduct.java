package com.mirzoyan.eshop.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction_product")
public class TransactionProduct {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    private Integer id;

    @NotNull
    @Size(max = 15)
    @Column(name = "hs_code")
    String hsCode;

    @NotNull
    @Column(name = "amount")
    Integer amount;

    @NotNull
    @Size(max = 17)
    @Column(name = "name")
    String name;

    @NotNull
    @Size(max = 17)
    @Column(name = "description")
    String description;

    @NotNull
    @Size(max = 17)
    @Column(name = "cmp_name")
    String companyName;

    @NotNull
    @Size(max = 17)
    @Column(name = "calorie")
    Integer calorie;

    @NotNull
    @Size(max = 17)
    @Column(name = "country")
    String country;

    @NotNull
    @Column(name = "dov")
    LocalDate validFrom;

    @NotNull
    @Column(name = "eov")
    LocalDate validTo;

    @Size(max = 255)
    @NotNull
    @Column(name = "company_name")
    String companyName;

    @NotNull
    @Column(name = "count")
    int count;
}
