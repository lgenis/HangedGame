package main;

import util.Input;

public class UserInterface {
	
	public static final String OPTION_SALIR = "salir";
	public static final String OPTION_JUGAR = "jugar";  
	public static final String OPTION_DIFICULTAD = "dificultad";
	public static final String OPTION_RESET="reset";
	
	public static final String OPTION_YES="SI";
	public static final String OPTION_NO="NO";

	
	//Eduard github.com/lordespirit/HangedGame/tree/edu
	
	//lordespirit/HangedGame
	public static void showMenuInit(int score){
		System.out.println("*******************");
		System.out.println("JUEGO DEL AHORCADO");
		System.out.println("*******************");
		System.out.println("Racha record: " + score);
		System.out.println("jugar\nsalir\ndificultad");
		System.out.print("Elige una opción : ");
	}
	
	public static String scanMenuInicio(){
		String option;
		boolean isOKI = false; 
		do{
			
			option = Input.scannLine().toLowerCase();
			isOKI = !(option.equals(OPTION_JUGAR)||
							  option.equals(OPTION_SALIR)||
							  option.equals(OPTION_DIFICULTAD));
			if(isOKI)
				System.out.println("Opción no válida. Vuelva a intentarlo: ");
			
		}while(isOKI);
		
		return option;
	}

	
	//Dorian:  
	public static void showMenuBoard(char[] wordPlayer, String hint, int attepts){		
		//if(attepts<2){			
			System.out.println("salir");
			System.out.println("reset");			
			System.out.println("Pista : " + hint);					
			char[] c = wordPlayer;
						
			for(int i=0; i<c.length;i++){
				System.out.print(c[i] + " ");			
			}				
			System.out.println("Intentos : " + attepts);			
		//}		
	}
	
	
	//Luis:  github.com/lgenis/HangedGame/
	public static String scanOpcionMenuBoard(){
		String valid=null;
		while(valid==null){
			String option=Input.scannLine().toLowerCase();
				if (option.equals(OPTION_SALIR)){
					valid=option; 
					break;
				}else if(option.equals(OPTION_RESET)){
					valid=option;
					break;
				}else if(option.length()==1){
					valid=option;
					break;
				}else{
					System.out.println(option + " No es opcion valida,Vuelva a intentarlo ");
				}
		}
		
		return valid;
	}
	
	

	public static void showMenuAgain(boolean winner, int streak){
		if (winner){
			System.out.println("\n\n\t\t\t HAS GANADO \t\t\t");
			System.out.print("\n\n\t\t Felicidades llevas " + (streak) + " racha");
			if (streak>1)
				System.out.print("s");
			System.out.print("\n\n\t Quieres continuar jugando?  teclea Si o No\n");
			
		}else{
			System.out.println("\n\t\t\t ----- ");
			System.out.println("\t\t\t |   O ");
			System.out.println("\t\t\t |   | ");
			System.out.println("\t\t\t |   ^ ");
			System.out.println("\t\t\t |_____");
			System.out.println("\n\t\t\t GAME OVER");
			System.out.print("\n\n\t Quieres continuar jugando?  teclea Si o No\n");
		}
	}
	
	
	public static String scanOptionMenuEndGame(){
		String key= Input.scannLine();
		key = key.toUpperCase();	
		String isKeyOk= null;				
		while (isKeyOk==null){
			switch (key){
				case "SI": 
					isKeyOk= key;
					break;
				case "NO":
					isKeyOk= key;
					break;
				default:
					System.out.print("\n\n\t Opcion no valida. Teclea Si o No. ");
					key=key.toUpperCase();
					break;			
			}			
		}
		return isKeyOk; 
	}
	
	public static int scanLevel(){
		System.out.println("Introduzca Nivel de dificultad:");
		System.out.println("1 - Facil");
		System.out.println("2 - Medio");
		System.out.println("3 - Dificil");
		int inp=Input.scannInt();
		switch (inp){
			case (1):
				return 5;

			case (2):
				return 4;
				
			case (3):
				return 3;
			
			default:
				System.out.println("Error, al seleccionar nivel.");
				System.out.println("Se seleciona 1 por defecto.");
				return 5;

				
		}
		
	
	}
	
	
	
	
	
	
	
	
	
}
