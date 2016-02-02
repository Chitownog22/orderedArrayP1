/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderedarrayp1;

import java.util.Arrays;


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
   
   
   public long[] pass(){
                  long[] arrayVal;
                 arrayVal = new long[100];
                 
                 
                return  arrayVal = a;

       /*for (int j=0; j<nElems; j++){
           
           arrayVal[j] = (int) a[j];
           System.out.println("test"+ arrayVal[j]);
       }*/
   }
   
   
   
   
   
   
   
   
   
   }  // end class OrdArray
////////////////////////////////////////////////////////////////



public class OrderedArrayP1 {

    public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      
      
      
      
      OrdArray arr2;
      arr2 = new OrdArray (maxSize);
        arr2.insert(22);
        arr2.insert(50);
      
      

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
      
      
      long[] arr1Holder ;
         arr1Holder = arr.pass();
         
         
      long[] arr2Holder ;
         arr2Holder = arr2.pass();
         
         
        
        
        merge(arr1Holder, arr2Holder);
      
      
    
      
      
      
      }  // end main()

    private static void merge(long[] arr1Holder, long[] arr2Holder) {
        
        boolean [] set = new boolean [1001]; 
        int totalItems = 0;

        long[] firstArr = arr1Holder;   // new arays to hold on passed values 
        long[] secondArr = arr2Holder;
        
            
       //new third array to combine
        long[] mergedArr = new long [firstArr.length + secondArr.length];
        
        
        
      
        
        
        // merge the arrays 
       System.arraycopy( firstArr, 0, mergedArr, 0, firstArr.length);
       System.arraycopy( secondArr, 0, mergedArr, firstArr.length, secondArr.length);

        
       
       /* attempt to remove dupes 
       for (int i=0; i< mergedArr.length; i++){
           
           if (counter == mergedArr[i] && !found){
                found =true;
           }
           else if (counter != mergedArr[i]){
              System.out.print(" "+ counter);
              counter = (int) mergedArr[i];
              found = false;
           }
           
       }
       
       System.out.print(" "+ counter);
*/
       
       
      //sort items
      for  ( int i=0; i <mergedArr.length; i++ ){
            for ( int j=i; j<mergedArr.length; j++){
                
                if (mergedArr[i]>mergedArr[j]){
                    int temp = (int) mergedArr[i];
                    mergedArr[i] = mergedArr[j];
                    mergedArr[j] = temp;
                }
            }
          
      }
       
      //print sorted
      
      for (int i=0; i < mergedArr.length; i++){
          
          System.out.print(mergedArr[i] + "\t");
      }
      
       System.out.println("printed sorted");
       
       
       System.out.println("dupes removed!");
       //after removing dupes   
       
       int b = 0; 
       mergedArr[b] = mergedArr[0];
       
       for ( int i=0; i< mergedArr.length; i++){
           if (mergedArr[b]!=mergedArr[i]){
               b++;
               mergedArr[b]=mergedArr[i];
           }
       }
       for (int i=0;i<=b;i++){
           System.out.print(mergedArr[i]+ "\t" );
       }
       
       
       
       
       
        //print for testing 
        
        System.out.println(mergedArr.length); //length of array
        
       
        

         System.out.println( Arrays.toString(firstArr));  //print first arr 
                  System.out.println( Arrays.toString(secondArr)); //print second arr 
                  
                                   System.out.println( Arrays.toString(mergedArr));  //print both arr 





    }
   

    
   
    
    
} // end class OrderedApp nothing entered yet
