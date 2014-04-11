/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programmierübung7;

import java.util.Arrays;

/**
 *
 * @author Marc
 */
public class Cube implements Comparable<Cube>{
    final int number;
    int s1, s2, s3;

    public Cube(int number, int s1, int s2, int s3) {
        this.number = number;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    
    public int getVolume(){
        return s1*s2*s3;
    }
    
    public int getSurface(){
        return 2*(s1*s2 + s2*s3+ s1*s3) ;
    }
    
    public int getMaxDimension(){
        
        int[] tempArray = {s1, s2, s3};
        int tempValue = -1;
        
        for(int a : tempArray){
            if(a > tempValue){
                tempValue = a;
            }
        }
        
        
        return tempValue;
        
    }
    
    
    public String toString(){
        return "C: " + s1+ " " + s2 + " "+ s3 + "\n";
    }
    
    @Override
    public boolean equals(Object other){
        if(this==other)
            return true;
        if(other==null)
            return false;
        if(this.getClass()!=other.getClass()){
            return false;
        }
        Cube temp = (Cube)other; 
        
        if(temp.number!=this.number){
            return false;
        }
        if(temp.s1 != this.s1){
            return false;
        }
        if(temp.s2 != this.s2){
            return false;
        }
        if(temp.s3 != this.s3){
            return false;
        }
              
        return true;
        
    }
    
    @Override
    public int hashCode(){
        int result = 0;
        result = s1;
        result += s2*3;
        result += s3*7;
        result += number*11;
        return result;
    }
    
    @Override
    public int compareTo(Cube c){
        if(c == this){
            return 0;
        }
        return this.getVolume() -c.getVolume();
      
    }
    
}
