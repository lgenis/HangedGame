package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	@SuppressWarnings("resource")
	public static int scannInt(){
		boolean badFormat = false;
		int var = 0;		
		do{			
			try {				
				Scanner reader = new Scanner(System.in); 
				var = reader.nextInt();
				badFormat = false;
				
			}catch (InputMismatchException iME){
				errMsg(var);
				badFormat = true; 
				
			}
			
		}while(badFormat);
		
	return var;
	}
		
	public static float scannFloat(){
		boolean badFormat = false;
		float var = 0f;
		do{
			try{
				Scanner reader = new Scanner(System.in);
				var = reader.nextFloat();
				badFormat = false;
				
			}catch (InputMismatchException iME){
				errMsg(var);
				badFormat = true;
			}
		}while(badFormat);
		//reader.close();
		return var;
	}
	
	public static String scannLine(){
		boolean badFormat = false;
		String var = null;
		do{
			try{
				Scanner reader = new Scanner(System.in);
				var = reader.nextLine();
				badFormat = false;
				
			}catch (InputMismatchException iME){
				errMsg(var);
				badFormat = true;
			}
		}while(badFormat);
		//reader.close();
		return var;
	}
	
	public static void errMsg(Object var){
		System.out.println("Solo " + var.getClass().getName() + " permitidos");
	}
}
