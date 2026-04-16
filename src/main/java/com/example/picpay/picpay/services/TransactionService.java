package com.example.picpay.picpay.services;

import com.example.picpay.picpay.domain.transaction.Transaction;
import com.example.picpay.picpay.repositories.TransactionRepository;
import com.example.picpay.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repositories;

    public void createTransaction(Transaction transaction) {

    }

}
