import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Author: Derek Zhu
 * 1and1get2@gmail.com
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003
 * */
// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
	public static boolean D = true;
	private static long factor = 2;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int numOfCases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < numOfCases; i++){
			calculateCase(Long.parseLong(in.readLine())); 
		}
		
		
	}
	private static void calculateCase(Long input) throws IOException{
//		889565456876
		factor = 2;
		
		long time = System.nanoTime();
		if (D) System.out.println("Processing: " + input);
		long largestPF;
		
		largestPF = prime2(input);
		if (D) System.out.println("Final calculate: " + largestPF + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		
		largestPF = method2(input);
		time = System.nanoTime();
		if(D) System.out.println("Final calculate 2: " + largestPF + " Time required to calculate in nanoseconds: " + (System.nanoTime() - time));
		
		if (!D) System.out.println(largestPF);
	}
	private static long method2(long NUMBER){
		long result = 0;
		if (isPrime(NUMBER)) return NUMBER;
        for(int i = 2; i < NUMBER; i++) {
            if(NUMBER % i == 0 && isPrime(NUMBER / i)) {
                result = NUMBER / i;
                break;
            }
        }
		return result;
        
	}
	private static boolean isPrime(long l) {
        for(long num = 2, max = l / 2 ; num < max; num++) {
            if(l % num == 0) {
                return false;
            }
        }
        return true;
    }
	private static long prime(long n){
		long i = 2;
		while ( n % i != 0 && i < n){
			i ++;
		}
		if (D) System.out.println("found factor i: " + i);
		
		if (i < n){
			return prime(n/i);
		} else {
			return n;
		}
	}
	private static long prime2(long n){
		
		while ( n % factor != 0 && factor < n){
			factor ++;
		}
		if (D) System.out.println("found factor i: " + factor);
		
		if (factor < n){
			return prime(n/factor);
		} else {
			return n;
		}
	}
	public static int primeFactors(BigInteger number)     {
	    BigInteger copyOfInput = number;
	    int lastFactor = 0;
	    for (int i = 2;
	    BigInteger.valueOf(i)
	    .compareTo(copyOfInput) <= 0; i++) {
	        if (copyOfInput.mod(BigInteger.valueOf(i))
	        .compareTo(BigInteger.ZERO) == 0) 
	        {
	            lastFactor = i;
	            copyOfInput = copyOfInput
	            .divide(BigInteger.valueOf(i));
	            i--;
	        }
	    }
	    return lastFactor;
	}
}
