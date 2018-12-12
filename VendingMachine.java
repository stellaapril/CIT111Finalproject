/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine;

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author sitian.chen
 */
public class VendingMachine {
     public static void main(String[] args){
         
        //product1
        Product doricheese = new Product();
        doricheese.name = "Doritos Cheese";
        doricheese.price = 1.75;
        doricheese.size = "1.25oz";
        doricheese.number = "A01";
        doricheese.amount = 5;
        
                        
        //product2
        Product layclassic = new Product();
        layclassic.name = "Lay's Chip Classic";
        layclassic.price = 1.75;
        layclassic.size = "1.5oz";
        layclassic.number = "A02";
        layclassic.amount = 2 ;
        
        //product3
        Product smartpop = new Product();
        smartpop.name = "Smartfood Popcorn";
        smartpop.price = 1.5;
        smartpop.size = "2oz";
        smartpop.number = "A03";
        smartpop.amount = 5 ;
        
        //product4
        Product mmchocolate = new Product();
        mmchocolate.name = "M&M milk chocolate";
        mmchocolate.price = 1.25;
        mmchocolate.size = "1.69oz";
        mmchocolate.number = "B01";
        mmchocolate.amount = 4 ;
        
        //product5
        Product oreo = new Product();
        oreo.name = "Oreo Cookies Vanilla Cream";
        oreo.price = 2;
        oreo.size = "70g";
        oreo.number = "B02";
        oreo.amount = 3 ;
        
        //product6
        Product nuts = new Product();
        nuts.name = "Planters Salted nuts";
        nuts.price = 1.5;
        nuts.size = "1.5oz";
        nuts.number = "B03";
        nuts.amount = 2 ;
        
        //product7
        Product coke = new Product();
        coke.name = "Coca Cola";
        coke.price = 1.75;
        coke.size = "20 fl oz";
        coke.number = "C01";
        coke.amount = 1 ;
        
        //product8
        Product dietcoke = new Product();
        dietcoke.name = "Dite Coke";
        dietcoke.price = 1.75;
        dietcoke.size = "20 fl oz";
        dietcoke.number = "C02";
        dietcoke.amount = 4 ;
        
        //product9
        Product sprite = new Product();
        sprite.name = "Sprite";
        sprite.price = 1.75;
        sprite.size = "20 fl oz";
        sprite.number = "C03";
        sprite.amount = 3 ;
        
        //product10
        Product vitaminzero = new Product();
        vitaminzero.name = "Vitamin Water Zero pineapple coconut";
        vitaminzero.price = 2.25;
        vitaminzero.size = "20 fl oz";
        vitaminzero.number = "D01";
        vitaminzero.amount = 25 ;
        
        //product11
        Product drpep = new Product();
        drpep.name = "Dr.Peper";
        drpep.price = 1.75;
        drpep.size = "20 fl oz";
        drpep.number = "D02";
        drpep.amount = 5 ;
        
        
        //product12
        Product water = new Product();
        water.name = "Dasani Purified Water";
        water.price = 1.75;
        water.size = "12 fl oz";
        water.number = "D03";
        water.amount = 20 ;
    
        
        
        //hashmap
        //connect the number of product to it's nmae price size amount
        HashMap<String,Product> productmap = new HashMap<>();
        productmap.put(doricheese.number,doricheese);
        productmap.put(layclassic.number,layclassic);
        productmap.put(smartpop.number,smartpop);
        productmap.put(mmchocolate.number,mmchocolate);
        productmap.put(oreo.number,oreo);
        productmap.put(nuts.number,nuts);
        productmap.put(coke.number,coke);
        productmap.put(dietcoke.number,dietcoke);
        productmap.put(sprite.number,sprite);
        productmap.put(vitaminzero.number,vitaminzero);
        productmap.put(drpep.number,drpep);
        productmap.put(water.number,water);
        
        //while loop to make sure after one user purchase it can back to the start 
        while(true){
           //display a diagram of machine
           Product.displaymachie();
           System.out.println("Ready to start? Y=1");
           Scanner userInput = new Scanner(System.in);
           int startUse = userInput.nextInt();
           if(startUse == 1){
               //display the detail of vending machine
               Product.displayProductdetail();
               
               //Choose product 
               System.out.println("Enter the number of item (Capital letter + number eg.A01) ");
               String productNum = userInput.next( );
               
               //productX is the product user choose
               Product retrivedproductX = productmap.get(productNum);
               
               //Check productX is instock or not
               if( retrivedproductX.checkInstockornot()){
                   //display productX price, size and amount instock
                   retrivedproductX.displayprice(retrivedproductX.amount,retrivedproductX.name,retrivedproductX.price,retrivedproductX.size);
                   
                   //get the amount of the productX user like to purchase
                   retrivedproductX.itemNum();
                   int itemnum = retrivedproductX.getNum();
                   
                   //display the total price
                   retrivedproductX.totalprice(itemnum,retrivedproductX.price);
                   
                   //check if the amount user input is less than or equal to the product instock amount 
                   if(itemnum<=retrivedproductX.amount){
                       
                       //after check the price, user can continue to check out or back to manue restart use the machine 
                        System.out.println("Check out = 1 / Back to main manue = 2");
                        int userChoice = userInput.nextInt();
                        System.out.println("\n-------------------------------------------");
                        
                        //check out
                        if(userChoice == 1){
                        
                        //choose payment
                        retrivedproductX.payment();
                        //minus amount of productX just purchased from the instock amount of productX
                        retrivedproductX.amount = retrivedproductX.amount - itemnum;
                        }//close inner if
                        
                   
                   }else{
                       //when productX is less than user input amount
                       System.out.println("Sorry,only have  "+retrivedproductX.amount+" "+retrivedproductX.name+"s");
                   }//close if/else
               
                }else{
                   //out of stock
                   System.out.println("Sorry! "+retrivedproductX.name+" is out of stock");
                }//close inner if/else
               
            }//close if
           
            System.out.println("                                                        ");
            System.out.println("                                                        ");
            
        }//close while
    }//close main
    
}//close class
