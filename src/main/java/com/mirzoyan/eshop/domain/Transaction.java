package com.mirzoyan.eshop.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "transaction_sequence")
    private Integer id;

    @NotNull
    @Column(name = "date")
    LocalDateTime transactionDate;

    @NotNull
    @Column(name = "total_amount")
    Integer totalAmount;

    @Column(name = "total_calorie")
    Integer totalCalorie;

    @Column(name = "total_mass")
    Integer totalMass;

    @Valid
    @NotEmpty
    @OneToMany(cascade = ALL)
    @JoinColumn(name = "transaction_id", nullable = false)
    private List<Product> productList = new ArrayList<>();

    @Valid
    @JoinColumn(name = "user_id")
    private String userId;
}
