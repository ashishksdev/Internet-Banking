package com.across.internetbanking.customer.controller;

import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.model.Gender;

public class CustomerForm {

    public String uniqueID(){
        System.out.print("Enter Unique ID: ");
        String uniqueID = Input.sc.next().trim();
        Input.sc.nextLine();
        return uniqueID;
    }
    
    public CustomerPersonalInfoDTO personalInfo(String uniqueID){
        
        // Collect customer personal details.
        System.out.print("Full name: ");
        String name = Input.sc.nextLine().trim();
        
        String genderString;
        Gender gender;
        while (true) { 
            try {
                System.out.print("Gender(Female/Male/Transgender/Other): ");
                genderString = Input.sc.next().toUpperCase().trim();
                Input.sc.nextLine();
                gender = Gender.valueOf(genderString);
                break;
            } catch (IllegalArgumentException genderException) {
                System.err.println("Gender could be Female/Male/Transgender/Other.");
            }
            
        }

        String ageString;
        int age = 0;
        while (true) { 

            try {
                System.out.print("Age: ");
                ageString = Input.sc.next();
                Input.sc.nextLine();
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException agFormatException) {
                System.err.println("Invalid age!");
            }
            

            if(age > 0 && age <= 120){
                break;
            } else{
                System.out.println("Invalid age!");
            }
        }

        String mobileNo;
        while (true) { 

            System.out.print("Mobile: ");
            mobileNo = Input.sc.next();
            Input.sc.nextLine();

            if(mobileNo.matches("\\d{10}")){
                break;
            } else{
                System.out.println("Invalid mobile number!");
            }
        }
        
        CustomerPersonalInfoDTO personalInfo = new CustomerPersonalInfoDTO(uniqueID, name, gender, age, mobileNo);
        
        return personalInfo;
    }
}