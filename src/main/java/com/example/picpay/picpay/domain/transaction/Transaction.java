package com.example.picpay.picpay.domain.transaction;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.math.BigDecimal;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;
}
