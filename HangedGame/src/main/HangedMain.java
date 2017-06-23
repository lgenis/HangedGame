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
	private static final int ACTION_EXIT =  3;
	private static final int ACTION_LEVEL = 4;
	private static final int ACTION_RESET=5;
	private static final int ACTION_WINNER = 6;
	private static final int ACTION_GAME_OVER = 7;


	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		int maxScore=0;
		int maxTries=5;
		String key;
		
		int action = 2; 
		
		HangedModel model = new HangedModel("C:\\poo\\git\\HangedGame\\HangedGame\\bin\\diccionario.dict");
		HangedBoard brd = new HangedBoard();
		HangedModel.SecretWord sw=null;
		
		// TODO leet maxScore
		// maxScore = 
		
		 do{
						
				switch(action){
				
					case ACTION_SHOW_MENU_INI:  {
						     UserInterface.showMenuInit(maxScore);					
				             action=optionToAction(UserInterface.scanMenuInicio()); 			             				             
					         break; 
						}
										
					case ACTION_WINNER: 
					case ACTION_GAME_OVER:  {				   
						 UserInterface.showMenuAgain(brd.isWinner(), brd.getStreak()); 
			             action=optionToAction(UserInterface.scanOptionMenuEndGame()); 			           
				         break; 
						}
				          					
					case ACTION_PLAY:  {
						sw =   model.getNextWord();
						action = loopGame(brd, sw, maxTries);
						
						if(action== ACTION_WINNER)
							 brd.addStrike();
						
						if(maxScore<brd.getStreak()){
							//TODO guardar maxScore
							maxScore =brd.getStreak();
						}
						
						
						if(action== ACTION_GAME_OVER)
							brd.reset();
						
						break;		 
						}
					
					case ACTION_LEVEL: {
						maxTries=UserInterface.scanLevel();
						action=ACTION_SHOW_MENU_INI;
						break;
						}
					
					case ACTION_RESET:{
						brd.reset();
						action=ACTION_PLAY;
						}
				}
				
		}while(action!=ACTION_EXIT);
		
	

	}
	
	
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
			return ACTION_SHOW_MENU_INI;
			
		case UserInterface.OPTION_YES:
			return ACTION_PLAY;
		
		default:
			return 0;
		}

	}
	
	public static int loopGame(HangedBoard board, SecretWord sw,  int maxTry){
		//TODO
		boolean exitGame=false;
		board.startGame(sw.word, maxTry);
		int r=0;
		
		do{
			
			UserInterface.showMenuBoard(board.getWordPlayer(), sw.hint, maxTry-board.getCurrentfails());
			String key=UserInterface.scanOpcionMenuBoard();
			switch(key){
				case UserInterface.OPTION_SALIR:
					r=ACTION_SHOW_MENU_INI;
					exitGame=true;
					break;
				case UserInterface.OPTION_RESET:
					r=ACTION_RESET; 
					exitGame=true;
				default:
					if (board.hasLetterInWordPlayer(key.toCharArray()[0])){
						System.out.println("Letra \""+ key.toCharArray()[0] + "\" ya utilizada, pruebe otra:");
					}else{
						board.addLetterToWordPlayer(key.toCharArray()[0]);
						if (board.isWinner()){
							r=ACTION_WINNER;
							exitGame=true;
						}else if ( board.isGameOver()){
							r=ACTION_GAME_OVER; 
							exitGame=true;
						}else{
							continue; 
						}						
					}
					//case anadir letra
				
			}
		}while(!exitGame);
		
		return r;
	}
}
