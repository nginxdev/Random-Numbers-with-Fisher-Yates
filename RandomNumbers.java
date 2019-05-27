package de.ovgu.cse.montecarlosimulator.xSparta;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class RandomNumbers
{
  public static void main(String args[])
  {
    List<BigDecimal[]> sampleProbs = new LinkedList<>();
    BigDecimal[] tmp = new BigDecimal[6];
    RandomNumbers randomNumbers = new RandomNumbers();
    double divVal = 1000;
  	int[] rand1 = randomNumbers.getUniDistRand(1000);
  	int[] rand2 = randomNumbers.getUniDistRand(1000);
  	int[] rand3 = randomNumbers.getUniDistRand(1000);
      for(int i=0 ; i<1000 ; i++) {
      	tmp = new BigDecimal[6];
      	tmp[0] = new BigDecimal((rand1[i]/divVal)).round(MathContext.DECIMAL64);
      	tmp[1] = new BigDecimal((1-rand1[i]/divVal)).round(MathContext.DECIMAL64);
      	tmp[2] = new BigDecimal((rand2[i]/divVal)).round(MathContext.DECIMAL64);
      	tmp[3] = new BigDecimal((1-rand2[i]/divVal)).round(MathContext.DECIMAL64);
      	tmp[4] = new BigDecimal((rand3[i]/divVal)).round(MathContext.DECIMAL64);
      	tmp[5] = new BigDecimal((1-rand3[i]/divVal)).round(MathContext.DECIMAL64);
      	sampleProbs.add(tmp.clone());
      }
      for (int i = 0 ; i < 1000 ; i++) {
			System.out.print(sampleProbs.get(i)[0]);
      }
      System.out.println();
      for (int i = 0 ; i < 1000 ; i++) {
			System.out.print(sampleProbs.get(i)[1]);
    }
  		
  }
  
  public int[] getUniDistRand(int n) {
	  int[] solutionArray = new int[n];
		for(int i=0 ; i<n ; i++) {
			solutionArray[i]=i+1;
		}
		shuffleArray(solutionArray);
	return solutionArray;
  }
  
  // Implementing Fisher–Yates shuffle
  static void shuffleArray(int[] ar)
  {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
}