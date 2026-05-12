package com.example.picpay.picpay.services;

import com.example.picpay.picpay.domain.dtos.TransactionDTO;
import com.example.picpay.picpay.domain.transaction.Transaction;
import com.example.picpay.picpay.domain.user.User;
import com.example.picpay.picpay.repositories.TransactionRepository;
import com.example.picpay.picpay.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

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

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());
        if(!isAuthorized){
            throw new  Exception("transação deu merda ");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> autorizationResponse = restTemplate.getForEntity("https//run.mocky.io/v3/8fafdd68-a090-496f-8c9a-344cf30dae6", Map.class);

        if (autorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) autorizationResponse.getBody().get("message");
            return true;
        } else return false;

    }
}
