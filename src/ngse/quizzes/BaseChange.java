package ngse.quizzes;

import java.util.Scanner;

public class BaseChange {
	private Scanner input = new Scanner(System.in);
	private int base10;
	private int fromBase;
	private int toBase;
	private String baseOther;
	private String output = "";
	private String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String args[]) {
		BaseChange baseChange = new BaseChange();
		System.out.println(baseChange.initChangeBase(/*"1bC", 16, 8*/));
		
		//System.out.println(new BaseChange().changeToBase10("55", 16));
	}
	
	public String initChangeBase() {
		System.out.println("Input number: ");
		baseOther = input.next();
		
		System.out.println("Input the base it is in: ");
		fromBase = input.nextInt();
		
		System.out.println("Input the desired base: ");
		toBase = input.nextInt();
		
		changeBase();
		
		return output;
	}
	
	public String changeBase(String baseOther, int fromBase, int toBase) {
		this.baseOther = baseOther;
		this.toBase = toBase;
		this.fromBase = fromBase;
		changeBase();
		return output;
	}
	
	private void changeBase() {
		changeToBase10();
		changeFromBase10();
	}
	
	public String initFromBase10() {
		System.out.println("Input number in base 10: ");
		base10 = input.nextInt();
		
		System.out.println("Input the desired base: ");
		toBase = input.nextInt();
		
		changeFromBase10();
		return output;
	}
	
	public String changeFromBase10(int base10, int base) {
		this.base10 = base10;
		this.toBase = base;
		changeFromBase10();
		return output;
	}
	
	private void changeFromBase10() {
		int top = 0;
		while (base10 - Math.pow(toBase, top) >= 0) {
			top++;
		}
		
		int currentRemainder = base10;
		
		for (int i = top - 1; i >= 0; i--) {
			int num = (int) (currentRemainder / Math.pow(toBase, i));
			output = output + chars.charAt(1);				
			currentRemainder -= Math.pow(toBase, i) * num; 
		}
	}
	
	public int initToBase10() {
		System.out.println("Input number: ");
		baseOther = input.next();
		
		System.out.println("Input the base it is in: ");
		fromBase = input.nextInt();
		
		changeToBase10();
		return base10;
	}
	
	public int changeToBase10(String baseOther, int base) {
		this.baseOther = baseOther;
		this.fromBase = base;
		changeToBase10();
		return base10;
	}
	
	private void changeToBase10() {
		base10 = 0;
		boolean error = false;
		for (int i = 0; i < baseOther.length(); i++) {
			char digit = baseOther.charAt(i);
			if (chars.indexOf(digit) != -1) {
				int index = chars.indexOf(digit);
				if (index >= fromBase){
					System.out.println("Illegal character.");
					error = true;
				}
				base10 += index
						* Math.pow(fromBase, baseOther.length() - i - 1);
			}
			else if (chars.indexOf(digit - 32) != -1) {
				int index = chars.indexOf(digit - 32);
				if (index >= fromBase){
					System.out.println("Illegal character.");
					error = true;
				}
				base10 += index 
						* Math.pow(fromBase, baseOther.length() - i - 1);
			}
			else {
				System.out.println("Illegal character.");
				error = true;
			}
			if (error) break;
		}
		if (error) base10 = 0;
	}
	
	
}
