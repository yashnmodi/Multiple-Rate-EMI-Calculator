/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
import java.util.*;

public class D {
     
  public static void main(String[] args){
    float p, np, inMon, pMon;
    short t, slaba, slabb;
    int mon;
    float[] say;
    float[] sby;
    float[] ratea;
    float[] rateb;
    float[] emiA;
    float[] emiB;
    float interestA = 0;
    float interestB = 0;
    
    Scanner sc = new Scanner(System.in);
    
    try{
    p = sc.nextFloat();
    np = p;
    t = sc.nextShort();
    
    slaba = sc.nextShort();
    say = new float[slaba];
    ratea = new float[slaba];
    emiA = new float[slaba];
    
    for(int i=0; i<slaba;i++){
        say[i] = sc.nextFloat();
        ratea[i] = sc.nextFloat();
    }
    
    slabb = sc.nextShort();
    sby = new float[slabb];
    rateb = new float[slabb];
    emiB = new float[slabb];
    
    for(int i=0; i<slabb;i++){
        sby[i] = sc.nextFloat();
        rateb[i] = sc.nextFloat();
    }
    
    
    for(int i=0; i<slaba; i++){
        emiA[i] = calEMI(np, ratea[i], say[i]);
         for (mon = 1; mon <= (say[i] * 12); mon++) {
            inMon  = np * (ratea[i] / 100);
            interestA += inMon;
            pMon = emiA[i] - inMon;
            np -= pMon;
         }
    }
    
    np = p;
    for(int i=0; i<slabb; i++){
        emiB[i] = calEMI(np, rateb[i], sby[i]);
        emiB[i] = calEMI(np, rateb[i], sby[i]);
         for (mon = 1; mon <= (sby[i] * 12); mon++) {
            inMon  = np * (rateb[i] / 100);
            interestB += inMon;
            pMon = emiB[i] - inMon;
            np -= pMon;
         }
    }
        
    if(interestA>=interestB)
        System.out.print("Bank B");
    
    if(interestA<interestB)
        System.out.print("Bank A");
    
    }
    catch(Exception e){
       System.out.println("information entered is not proper.");
    }
  }

  static float calEMI(float p, float monRate, float t)
    {
        float emi;
     
        monRate = monRate/(12 * 100);
        t = t * 12;
        emi = (p * monRate * (float)Math.pow(1 + monRate, t)) 
                / (float)(Math.pow(1 + monRate, t) - 1);
     
        return emi;
    } 
}
