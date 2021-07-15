package com.perion.ironbank.services;

import com.perion.ironbank.dao.BankRepo;
import com.perion.ironbank.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class IronBankService {

    @Autowired
    private BankRepo bankRepo;

    @Autowired
    private PredictionService predictionService;


    public String loan(String name, int balance) {
        Bank bank = bankRepo.findAll().iterator().next();
        if (bank.getBalance() < balance) {
            throw new NotEnoughMoneyException("no money in the bank");
        }
        if (predictionService.willSurviveTheWinter(name)) {
            bank.setBalance(bank.getBalance() - balance);
            return "loan accepted current balance in the bank is: " + bank.getBalance();
        }else {
            return "loan rejected, you will not survive the winter, or we just don't like you";
        }











    }


    @EventListener(ContextRefreshedEvent.class)
    public void fillBank(){
        Bank bank = new Bank();
        bank.setBalance(100);
        bankRepo.save(bank);
    }
}


