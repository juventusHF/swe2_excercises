package ch.juventus.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    final Logger logger = LoggerFactory.getLogger(Bank.class);

    private double balance;

    public Bank() {
        this.balance = 0d;
        logger.debug("New bank initialized. Balance = {}", balance);
    }

    public void withdraw(double amount) {
        logger.info("Withdraw {} from bank", amount);
        balance = balance - amount;
        logger.info("New balance is {}", balance);
    }

    public void deposit(double amount) {
        logger.info("Deposit {} in bank", amount);
        balance = balance + amount;
        logger.info("New balance is {}", balance);
    }

    public double retrieveBalance() {
        logger.info("Current balance is {}", balance);
        return balance;
    }
}
