package main;

import util.Input;



public class UserInterface {
	public static String showMenuInit(){
		return null;
	}
	
	public static String showMenuBoard(String wordPlayer, String hint, int attempts){
		System.out.println("Tablero:");
		System.out.println("\nPista: " +hint );
		
		System.out.println("\n"+wordPlayer);
		System.out.println("\nIntentos restantes:"+attempts);
		String valid=null;
		
		while(valid==null){
			String option=Input.scannLine();
			
		
				if (option.equals("exit")){
					valid=option; 
					break;
				}else if(option.equals("reset")){
					valid=option;
					break;
				}else if(option.length()==1){
					valid=option;
					break;
				}else{
					System.out.println(option + " NO es opcion valida");
				}
		}
		
		return hint;
	}
	
	public static void showMenuAgain(boolean winner){
		
	}
}
