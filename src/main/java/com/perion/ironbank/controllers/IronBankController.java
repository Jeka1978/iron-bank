package com.perion.ironbank.controllers;

import com.perion.ironbank.services.IronBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/api/bank")
public class IronBankController {


    @Autowired
    private IronBankService bankService;

    @GetMapping("/loan")
    public String loan(@RequestParam String name, @RequestParam Integer amount) {
        return bankService.loan(name, amount);
    }
}
