package com.across.internetbanking.customer.controller;

import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;

public class CustomerForm {

    public String uniqueID(){
        System.out.print("Enter Unique ID: ");
        return Input.sc.next().trim();
    }
    
    public CustomerPersonalInfoDTO personalInfo(String uniqueID){
        
        // Collect customer personal details.
        System.out.print("Full name: ");
        String firstName = Input.sc.next();
        String lastName = Input.sc.next();
        Input.sc.nextLine();

        System.out.print("Gender: ");
        char gender = Input.sc.next().charAt(0);

        int age;
        while (true) { 

            System.out.print("Age: ");
            age = Input.sc.nextInt();

            if(age < 0 || age > 120){
                System.out.println("Invalid age!");
            } else{
                break;
            }
        }

        long mobileNo;
        while (true) { 

            System.out.print("Mobile: ");
            mobileNo = Input.sc.nextLong();
            int mobileLength = String.valueOf(mobileNo).trim().length();

            if(mobileLength != 10 ){
                System.out.println("Invalid mobile number!");
            } else{
                break;
            }
        }

        CustomerPersonalInfoDTO personalInfo = new CustomerPersonalInfoDTO(uniqueID, firstName, lastName, gender, age, mobileNo);
        
        return personalInfo;
    }
}