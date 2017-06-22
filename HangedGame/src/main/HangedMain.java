package main;

import main.HangedModel.SecretWord;

/**
 *  Aplicación para jugar Ahorcado similar a la publicada en: 
	http://pasatiempos.elmundo.es/ahorcado/ahorcado.html 
	 
	En este caso la interfaz de usuario se realizará mediante línea de comandos
	
	 Caracteristicas :
	 
	-Iniciar partida
	-Al inicio de cada partida debe mostrarse una pista para la palabra secreta (e.j pais, nombre, provincia, etc) 
	-Durante el juego el usuario podrá reiniciar  la palabra secreta, pero la racha ganadora se reiniciará también. 
	-Cuenta regresiva de fallos
	-Racha ganadora actual y récord de racha ganadora ganadora (con nick si es el caso)
	-Mensaje Partida ganada
	-Mensaje Partida perdida
	-Si el jugador supera el récord de la racha ganadora, mensaje felicitación y opción de guardar su nick (archivo).
	-Salir del juego
	-Diccionario con minimo 20 palabras
	

 * @author campino
 *
 */

public class HangedMain {
	
	
	private static final int ACTION_PLAY =  1;
	private static final int ACTION_SHOW_MENU_INI = 2; 
	private static final int ACTION_EXIT =  9;
	private static final int ACTION_LEVEL = 8;
	private static final int ACTION_SHOW_MENU_AGAIN = 5;
	
	private static final int ACTION_RESET=7;


	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		int scor=0;
		int maxTries=5;
		String key;
		
		int action = 2; 
		
		HangedModel model = new HangedModel("diccionario.dict");
		HangedBoard brd = new HangedBoard();
		
		do{
			
			
				switch(action){
				
					case ACTION_SHOW_MENU_INI:  {
						     UserInterface.showMenuInit(scor);
				             action=optionToAction(UserInterface.scanMenuInicio()); 
				             
				             
					         break; 
					}
					
					case ACTION_SHOW_MENU_AGAIN:  {
					   
						UserInterface.showMenuAgain(brd.isWinner(), brd.getStreak()); 
			             action=optionToAction(UserInterface.scanOptionMenuEndGame()); 
			             if (action==ACTION_PLAY && brd.isWinner()){
			            	 brd.addStrike();
			             }else
			            	 action=ACTION_RESET;
				         break; 
					}
				          
					
					case ACTION_PLAY:  {
						HangedModel.SecretWord sw = model.getNextWord();
						UserInterface.showMenuBoard(brd.getWordPlayer().toString(), sw.hint, maxTries-brd.getCurrentfails());
						action = loopGame(brd, sw, maxTries);
						break;
						 
					}
					case ACTION_LEVEL: {
						maxTries=UserInterface.scanLevel();
						break;
					}
					case ACTION_RESET:{
						//TODO
						//brd.reset(brd., brd.getMaxFails());
					}
				}
			
			
			
			/*
			switch(key){
				case UserInterface.OPTION_JUGAR:
					
					main.HangedModel.SecretWord sw=model.getNextWord();
				
					exit=loopGame(brd, sw,  maxTries); 
					
				case UserInterface.OPTION_SALIR:
					exit=true;
					break;
					
				case UserInterface.OPTION_DIFICULTAD:
					maxTries=UserInterface.scanLevel();
					break;
			} */
			
			
			
			
		}while(action!=ACTION_EXIT);
		
	

	}
	/*
	private static int scanOptionMenuAgain() {
		// TODO Auto-generated method stub
		return 0; 
	}
	
	
	public static int scanOptionMenuIni(){
		String key = UserInterface.scanMenuInicio();
		int r=0;
		
		switch(key){
			case UserInterface.OPTION_JUGAR:
				  r = ACTION_PLAY; break; 			  
			case UserInterface.OPTION_SALIR:
				  r = ACTION_EXIT;  break;
			case UserInterface.OPTION_DIFICULTAD:
				  r = ACTION_LEVEL; break;
		}
		return r; 
	}*/
	
	public static int optionToAction(String action){
		switch (action){
		case UserInterface.OPTION_DIFICULTAD:
			return ACTION_LEVEL;
			
		case UserInterface.OPTION_JUGAR:
			return ACTION_PLAY;
			
		case UserInterface.OPTION_RESET:
			return ACTION_RESET;
			
		case UserInterface.OPTION_SALIR:
			return ACTION_EXIT;
		
		case UserInterface.OPTION_NO:
			return ACTION_EXIT;
			
		case UserInterface.OPTION_YES:
			return ACTION_PLAY;
		
		default:
			return 0;
		}

	}
	
	public static int loopGame(HangedBoard board, SecretWord sw,  int maxTry){
		//TODO
		boolean exit2=false;
		board.startGame(sw.word, maxTry);
		int r=0;
		
		do{
		
			String key=null;
			switch(key){
			case UserInterface.OPTION_SALIR:
				
				
			case UserInterface.OPTION_RESET:
				board.reset(sw.word.toCharArray(), maxTry);
				
				
				//case anadir letra
				
			}
		}while(!exit2);
		
		return 0;
	}
}
