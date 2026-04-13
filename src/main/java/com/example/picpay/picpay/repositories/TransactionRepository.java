package com.example.picpay.picpay.repositories;


import com.example.picpay.picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
