package com.example.picpay.picpay.services;

import com.example.picpay.picpay.domain.user.User;
import com.example.picpay.picpay.domain.user.UserType;
import com.example.picpay.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal anount) throws Exception{
        if (sender.getUserType() == UserType.MERCHANT){
                throw new Exception("gg");
        }

        if (sender.getBalance().compareTo(anount) < 0){
            throw new Exception("xd");
        }
    }
}
