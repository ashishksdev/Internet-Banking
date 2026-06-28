package com.across.internetbanking.auth.controller;

import com.across.internetbanking.account.controller.AccountForm;
import com.across.internetbanking.account.factory.AccountFactory;
import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.account.model.AccountStatus;
import com.across.internetbanking.account.model.AccountType;
import com.across.internetbanking.account.repository.AccountRepository;
import com.across.internetbanking.account.service.AccountNumber;
import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.service.SignupService;
import com.across.internetbanking.auth.service.security.PasswordHash;
import com.across.internetbanking.auth.validator.SignupValidation;
import com.across.internetbanking.customer.controller.CustomerForm;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.factory.CustomerFactory;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.factory.UserFactory;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;
import com.across.internetbanking.user.service.UserID;
import com.across.internetbanking.user.validator.IsCompatiblePassword;

public class Signup {

    private final CustomerRepository CUSTOMER_DATA;
    private final UserRepository USER_DATA;
    private final AccountRepository ACCOUNT_DATA;
    private final PasswordHash passwordHash;

    public Signup(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA, AccountRepository ACCOUNT_DATA, PasswordHash passwordHash){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        this.ACCOUNT_DATA = ACCOUNT_DATA;
        this.passwordHash = passwordHash;
    }

    public void onboardClient(){
        Customer customer = customerCreation(); // Create customer
        User user = userCreation(customer); // Create User
        Account account = accountCreation();
        // Account bankAccount = orchestrateAccountCreation(); // Create Account

        SignupService signupService = new SignupService(CUSTOMER_DATA, USER_DATA, ACCOUNT_DATA);

        // Link Bank account---User---Customer, in SignupService
        signupService.link(customer, user, account);

        // After successfull linkage, update to database.
        signupService.addClient(customer, user, account);
        account.updateAcStatus(AccountStatus.ACTIVE);// Update Account status to ACTIVE
    }

    private Customer customerCreation(){
        CustomerForm customerForm = new CustomerForm();

        // Get Unique ID input and validate it in databse.
        String uniqueIDInput = customerForm.uniqueID();
        SignupValidation signupValidation = new SignupValidation(CUSTOMER_DATA);
        if(signupValidation.validateUserId(uniqueIDInput)){
            throw new UIDAlreadyExistsException("User already exist.");
        }

        // When Unique ID is validated and found new, collect personal info of customer.
        CustomerPersonalInfoDTO personalInfo = customerForm.personalInfo(uniqueIDInput);
    
        // Create a new customer as per his/her personal details.
        CustomerFactory factory = new CustomerFactory();
        Customer customer = factory.create(personalInfo); // New Customer.

        return customer;
    }

    private User userCreation(Customer customer){
        UserID userID = new UserID(USER_DATA);
        String tempPassword;

        String newUserID = userID.generateUnique(customer.name());
        displayAssignedUserID(newUserID);

        PasswordForm passwordForm = new PasswordForm();
        IsCompatiblePassword validator = new IsCompatiblePassword();

        while (true) { 
            tempPassword  = passwordForm.promptForPassword(); // Password input

            if(validator.validate(tempPassword)){
                break; // Password validated true.
            }
            System.err.println("Password must be at least 4 characters and contain an uppercase, lowercase, digit, and symbol. Retry!"); // Password denied in validation message.
        }

        // Pass validPassword for salting and hashing.
        final String validPassword = tempPassword;
        String salt = passwordHash.generateSalt();
        String hashedPassword = passwordHash.hashPassword(validPassword, salt);

        // Create a new User as per User ID and Password.
        UserFactory factory = new UserFactory();
        User user = factory.create(newUserID, hashedPassword, salt, passwordHash);

        return user;
    }

    public void displayAssignedUserID(String userID){
        System.out.printf("Your User ID: %s%n", userID);
    }

    private Account accountCreation(){
        AccountForm acForm = new AccountForm();
        // Input account type
        AccountType accountType = null;
        boolean validAccountType;
        do { 
            try {
                accountType = acForm.promptForAccountDetail();
                validAccountType = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Inavlid Account type. Try again!");
                validAccountType = false;
            }
        } while (!validAccountType);
        
        AccountNumber accountNumber = new AccountNumber(ACCOUNT_DATA);

        String newAccountNumber = accountNumber.generate(); // generate unique account number.
        AccountFactory factory = new AccountFactory(accountType);
        Account account = factory.create(newAccountNumber);
        
        return account;
    }
}