package com.perion.ironbank.dao;

import com.perion.ironbank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface BankRepo extends CrudRepository<Bank,Integer> {
    List<Bank> findByBalanceGreaterThan(int balance);

}
