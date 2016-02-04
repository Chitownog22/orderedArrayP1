/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderedarrayp1;

import java.util.Arrays;
import java.util.Random;


// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j;
      for(j=0; j<nElems; j++)        // find where it goes
         if(a[j] > value)            // (linear search)
            break;
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   
   // class object to pass array values  
   public long[] pass(){
                  long[] arrayVal; //this objects array 
                 arrayVal = new long[100]; // this object's array max length 
                 
                 
                return  arrayVal = a; //returns the value of the array 

    
   }
     //-----------------------------------------------------------
 
   
   }  // end class OrdArray
////////////////////////////////////////////////////////////////



public class OrderedArrayP1 {

    public static void main(String[] args)
      {
      int maxSize = 11;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array
      
      
  
    
     

      arr.insert(   callRAndom() );                // insert 10 items
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(  callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      arr.insert(   callRAndom() );
      
      
      
      
      
      OrdArray arr2;                    //reference to array 
      arr2 = new OrdArray (maxSize);    //create new instance of the class
      
        arr2.insert(   callRAndom() );  
        arr2.insert(   callRAndom() );
        arr2.insert(  callRAndom() );
        arr2.insert(   callRAndom() );
        arr2.insert(   callRAndom() );

       
      
      

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      System.out.print ("Print out first arr ");
      arr.display();                 // display items
      
        System.out.print ("Print out seccond arr ");
      arr2.display();                 // display items
      
              System.out.print ("\n" + "\n");

      

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      System.out.print(" Print array One after deletion is complete: ");
      arr.display();                 // display items again
      
      System.out.print(" \n Print array two after deletion is complete: ");
      arr2.display();                 // display items again
      
      
                                //passing array's  value
      long[] arr1Holder ;
         arr1Holder = arr.pass();
         
         
      long[] arr2Holder ;
         arr2Holder = arr2.pass();
         
         
        
        
        merge(arr1Holder, arr2Holder);
        common(arr1Holder, arr2Holder);
      
      
    
      
      
      
      }  // end main()

    
    //merge method - merges 2 arrays 
    private static void merge(long[] arr1Holder, long[] arr2Holder) {
        
       
        
        long[] firstArr = arr1Holder;   // new arays to hold on passed values 
        long[] secondArr = arr2Holder; // 2nd array passed 
         
       //new third array to merge the top 2 
        long[] mergedArr = new long [firstArr.length + secondArr.length];
        
        
        
      
    // merged the arrays 
       System.arraycopy( firstArr, 0, mergedArr, 0, firstArr.length);
       System.arraycopy( secondArr, 0, mergedArr, firstArr.length, secondArr.length);

        
       
    
                                                     /* sort and remove duplicates */ 
    //sort items
      for  ( int i=0; i < mergedArr.length; i++ ){
            for ( int j=i; j< mergedArr.length; j++){
                
                if (mergedArr[i] > mergedArr[j]){
                    int temp = (int) mergedArr[i];
                    mergedArr[i] = mergedArr[j];
                    mergedArr[j] = temp;
                }
            }
          
      }
       
 
         System.out.print("\n \n merged array before duplicates Removed: " + "\n");

                                   System.out.println( Arrays.toString(mergedArr));  //print both arr 
      
      
       
    // Remove Duplicates 
       System.out.println("\n \n dupes removed!");
       //after removing dupes   
       
       int b = 0; 
       mergedArr[b] = mergedArr[0];
       
       for ( int i=0; i< mergedArr.length; i++){
           if (mergedArr[b]!=mergedArr[i]){
               b++;
               mergedArr[b]=mergedArr[i];
           }
       }
       for (int i=0;i<=b;i++){                          //print
           System.out.print(mergedArr[i]+ ", " );
       }
       
       
       
       
       /*
        //print for testing 
        
        System.out.println("\n array size " + mergedArr.length); //length of array
        
       */
        


 System.out.println( "\n \n ");   





    }

    private static void common(long[] arr1Holder, long[] arr2Holder) {
       
        
        
          long[] firstArr = arr1Holder;   // new arays to hold on passed values 
        long[] secondArr = arr2Holder; // 2nd array passed 
         
       //new third array to merge the top 2 
        long[] mergedArr = new long [firstArr.length + secondArr.length];
        
        
        
      
    // merged the arrays 
       System.arraycopy( firstArr, 0, mergedArr, 0, firstArr.length);
       System.arraycopy( secondArr, 0, mergedArr, firstArr.length, secondArr.length);

       
       
       
         //sort items
        for  ( int i=0; i < mergedArr.length; i++ ){
            for ( int j=i; j< mergedArr.length; j++){
                
                if (mergedArr[i] > mergedArr[j]){
                    int temp = (int) mergedArr[i];
                    mergedArr[i] = mergedArr[j];
                    mergedArr[j] = temp;
                }
            } 
         }
       
       
       
       
       
      // show common numbers 
      int g =0;    // counter 
      
      long[] commonArr = new long [g];  // new array to hold common values
     
      System.out.print("These are the Common Values: " + "\n");
      
        for(int i=0;i<firstArr.length;i++){     // loop whie i is less than our array
            for(int j=0;j<secondArr.length;j++){
                if(firstArr[i]==secondArr[j] && firstArr[i] != 0){   //check if values are the same 
                    System.out.print(firstArr[i] + " ");            //print values 
                    g++;                                            //counter add 
                }
            }
        }
      
        
    }

    private static long callRAndom() {
        
        int max = 100;
        int min = 1;
        
        Random rand = new Random();
        
      int randomNum = rand.nextInt((max-min) + 1) + min;
      
      return (long) randomNum;
    }
   

    
   
    
    
} // end class OrderedApp nothing entered yet
