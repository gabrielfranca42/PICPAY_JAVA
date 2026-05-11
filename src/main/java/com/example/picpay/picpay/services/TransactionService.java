package com.example.picpay.picpay.services;

import com.example.picpay.picpay.domain.dtos.TransactionDTO;
import com.example.picpay.picpay.domain.transaction.Transaction;
import com.example.picpay.picpay.domain.user.User;
import com.example.picpay.picpay.repositories.TransactionRepository;
import com.example.picpay.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repositories;

    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction)throws  Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());
    }


}
