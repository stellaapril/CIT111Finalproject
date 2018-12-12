/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine;

import java.util.Scanner;
/**
 *
 * @author sitian.chen
 */
public class Product {
    //public variables
    public double price;
    public String number;
    public String name;
    public String size;
    public int amount;
    
    
    //private variables
    private boolean isProductinstock;
    private boolean useCard;
   
    
    //display vending machine diagram
    public static void displaymachie(){
        System.out.println("   _____________________________");
        System.out.println("  /                            /|");
        System.out.println(" /                            / |");
        System.out.println("/____________________________/  |");
        System.out.println("|     VENDING MACHINE       |   |");
        System.out.println("|___________________________|   |");
        System.out.println("|  A01  |   A02  |  A03 |   |   |");
        System.out.println("|_______________________|   |   |");
        System.out.println("|  B01  |   B02  |  B03 |   |   |");
        System.out.println("|_______________________|---|   |");
        System.out.println("|  C01  |   C02  |  C03 | | |   |");
        System.out.println("|_______________________| | |   |");
        System.out.println("|  D01  |   D02  |  D03 |---|   |");
        System.out.println("|_______________________|   |   |");
        System.out.println("|                       |   |  /");
        System.out.println("|_______________________|   | / ");
        System.out.println("|_______________________|___|/ ");
        System.out.println("                                ");
        
    }//close method
    
    //Detail of vending machine to show products and thier number
    public static void displayProductdetail(){
        System.out.println("                             ");
        System.out.println("_____________________________"); 
        System.out.println("|  A01   |   A02   |  A03   |");
        System.out.println("|Doritos |  Chip   |Popcorn |");
        System.out.println("|________|_________|________|");
        System.out.println("|  B01   |   B02   |  B03   |");
        System.out.println("|  m&m   |  OREO   |  Nuts  |");
        System.out.println("|________|_________|________|");
        System.out.println("|  C01   |   C02   |  C03   |");
        System.out.println("|  Coke  |Diet Coke| Sprite |");
        System.out.println("|________|_________|________|");
        System.out.println("|  D01   |   D02   |  D03   |");
        System.out.println("|VitaZero| Dr.Peper|  Water |");
        System.out.println("|________|_________|________|");
        System.out.println("                             ");
        
    }//close method
    
    //check instock or not method 
    //when it's out of stock it can not do purchase      
    public boolean checkInstockornot(){
        if(amount > 0){
            isProductinstock = true;
        }else{
            isProductinstock = false;
        }//close if/else
        return isProductinstock;
    }//close method
    
    
    //display product price method
    //to show the price and size of the product
    public void displayprice(int amount,String name,double price,String size){
        System.out.println("                                          ");
        System.out.println("-------------------------------------------");
        System.out.println(name);
        System.out.println("Size:"+ size);
        System.out.println("Total Price: "+price+"$");
        System.out.println("Instock: "+ amount);
        System.out.println("-------------------------------------------");
        
    }//close method
    
    //get the number of item user will do purchase
    public int itemnum;
    public void itemNum(){
        System.out.println("How many items do you like to purchase?");
        Scanner userInput1 = new Scanner(System.in);
        itemnum = userInput1.nextInt();
        
    }//close method
    
    public int getNum(){
        return itemnum;
    }//close method
    
    //to calculate the final price
    double finalprice;
    public void totalprice(int number, double price){
        finalprice = number*price;
        System.out.println("\nYour total price is"+finalprice); 
        System.out.println("\n-------------------------------------------");
    }//close method
    
    public double getfinalprice(){
        return finalprice;
    }  
    
    
    
    
    //choose payment method
    public boolean payment(){
        //choose credit or cash
        System.out.println("Payment:  Credit Card =1    Cash = 2");
        Scanner keyboard = new Scanner(System.in);
        int userPayment = keyboard.nextInt();
        if (userPayment == 1){
            System.out.println("Please insert your credit card");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("Please remove your card");
            System.out.println("-------------------------------------------\n");
            System.out.println("Would you like to print your receipt? Y=1 N=2");
            
            //boolean of print receipt or not 
            int userreceipt = keyboard.nextInt();
            if(userreceipt == 1){
                //if user choose to print receipt, call the method of creditcard receipt
                cardReceipt();
            }else{
                //if user choose not to print the receipt
                System.out.println("Thank you!");
            }//close inner if/else
            //boolean to show user use creditcard to pay for it
            useCard = true;
            
        }else{
            //choose the cash user prepare to insert the vending machine
            System.out.println("Please insert 5$ / 10$ / 20$ \n"
                    + "(5$=5 / 10$=10 / 20$=20)");
            int userCash = keyboard.nextInt();
            System.out.println("-------------------------------------------\n");
            //check if the cash user insert machine enough money to purchase
            if(userCash >= getfinalprice()){
                System.out.println("Would you like to print your receipt? Y=1 N=2");
                int userreceipt = keyboard.nextInt();
                if(userreceipt ==1){
                    //call the cashreceipt mehtod
                    cashReceipt(userCash,getChange(userCash, getfinalprice()));
                    
                //if user choose not to print the receipt 
                }else{
                    
                     System.out.println("Thank you!");
                    }//close inner if/else
                
                //get change
                //dispaly the change and quarter user will get
                displayquarter(getChange(userCash, price));
                
            //when user insert cash is not enough to purcahse    
            }else{
                System.out.println("Sorry. Insert cash is not enough to purchase.");
                System.out.println("-------------------------------------------\n");
            }
            //boolean to show the user is not use creditcard to pay for it
            useCard = false;
        }//close if/else
        
        return useCard;
    }//close method
    
    
    
    //change method 
    //to calculate how many change will user get when they use cash to pay
    public double getChange(double cashamount, double finalprice){
        double change = cashamount - finalprice;
        
        return change;
    }//close method
    
    
    //display quarter meethod
    //to show how many quarters will user get and display how many quarters will give back to user
    public static void displayquarter(double change){
        double quarterNum = change/0.25;
        System.out.println("\n-------------------------------------------");
        System.out.println("Here are your change: "+ quarterNum +" quarters ");
        
        while(quarterNum>0){
            System.out.print(" o ");
            quarterNum = quarterNum-1;
        }//close while
        System.out.println("\n-------------------------------------------");
        System.out.println("                                       ");
    }//close method
    
    //card receipt method 
    //to show the method user use to pay and the date and the name of product and the price
    public void cardReceipt(){
        System.out.println("                                       ");
        System.out.println("                                       ");
        System.out.println("******************RECEIPT******************");
        System.out.println("PAYMENT: CARD# ************0414");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("DATE:                             12/12/2018");
        System.out.println(name+"    @"+getNum()+"    "+price+"$");
        System.out.println("TOTAL:    "+finalprice+"$");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("               Customer Copy               ");
        System.out.println("*******************************************");
    }//close mehtod
    
    //cash receipt method 
    //to show the method user use to pay and the date and the name of product and the price
    public void cashReceipt(double usercash,double totalChange ){
        System.out.println("                                       ");
        System.out.println("                                       ");
        System.out.println("******************RECEIPT******************");
        System.out.println("DATE:                             12/12/2018");
        System.out.println("PAYMENT: CASH");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println(name +"@"+getNum()+"   "+price+"$");
        System.out.println("TOTAL:     "+finalprice+"$");
        System.out.println("PAY:       "+usercash+"$");
        System.out.println("CHANGE:    "+totalChange+"$");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("                                           ");
        System.out.println("               Customer Copy               ");
        System.out.println("*******************************************");
    }//close method
    
}//close class
