package com.rga.q;


/**
 * 
 * Intuit needs to categorize transactions (e.g., "Travel," "Business," "Tax Deductible"). Design and implement a simple system that allows us to apply a set of rules to a stream of transactions.

    Task - Build a system that takes a Transaction object and assigns a Category based on dynamic rules.

Rules - category
-Travel, 
-Business
-Tax
-High value transaction 



Category rule-> applied to Transaction object
- Transaction - rolex 
- value >  
- transaction -> identifier 

 */
//Rules[]




public class Intuit {
    
    //input - transaction object 
    // Rule engine - loads rule 
        // Rule emits score fo ran input 
        // Rule have priority [Rule0, Rule1] -> Sequentially with Rule Id 
        // score*weight %10 == final score//0-10
        //This decides the categogy 

        //Transaction.amount();
        //Transaction.brand();
    
    // Enum {
    //     "highVaue"//Travel//Tax
    // }

    // Class HighValueWatchRule implents {
        
    //     int Transcation vaule;
    //     highTreshold
    //     lowThreshold
    //     int priority 
    //     Category - // Travel
    //         ...
    //     Enum.Cateory execute(Transaction tns){
            
    //         //execute 
    //         if(tns.amount > Highthreshold && tns.category=watchrule )
    //             return enum.highCategory

    //     }
    // }    

   // class RuleEngine{
        //load rules like 
        // Nesting of rule 
        //-> Rule 1 (high) o/p -> rule 2
    //     loads();
    //     COncurrentHashMap <String, List<Rules>>
    //     Enum identifyCategory(Transaction Object);//Tax vs travel



    // }


    // Class Transaction{

        //Accept a tranction
        //Identify its category --- 
        // RuleEngine(Transaction tns, Array[Enum.HighValue]); //Optional 


   // }


}
