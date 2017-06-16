package main;


import util.FileHelper;

/**
 * Esta clase funciona como diccionario de palabras. Las palabras se guardaran en un archivo, cada linea 
 * correspondera a un par palabra:pista
 * 
 * @author campino
 *
 */
public class HangedModel {
	
	private String[] newWord;
	
	@Deprecated
	private String[] oldWord;

	final String FILE_NAME;
	
	public HangedModel(String fileDictionary){
		
		FILE_NAME=fileDictionary;
		loadWords();
	}
	
	
	/**
	 * Carga todo el diccionario de palabras desde el fichero
	 */
	private void loadWords(){
		newWord= FileHelper.readFile(this.FILE_NAME);	
	}
	
	/**
	 * retorna una palabra seleccionada aleatoriamente del arreglo newWord
	 * si no hay mas palabras disponibles en newWord, reinicia los arreglos. 
	 * es decir carga nuevamente las palabras desde el fichero con loadWords()
	 * @return
	 */
	
	
	public SecretWord getNextWord(){
		
		if (newWord.length==0){
			loadWords();
		}
	
		int index=(int) (newWord.length*(Math.random()));
		
		String palabra = newWord[index]; 
		removeFromNewWords(index); 
		
		return new SecretWord(palabra);  
	}


	private void removeFromNewWords(int index) {
		// TODO Auto-generated method stub
		String[] reducedNewWord=new String[newWord.length-1];
		
		if(index<0 || index>=newWord.length) return;
		
		int j=0;
		
		for (int i=0; i<newWord.length; i++){
			if(i!=index){
				reducedNewWord[j]=newWord[i];
				j++;
			}
		}
		
		newWord=reducedNewWord;
		
	}
	
	public static class SecretWord{
		public final String word; // palabra secreta
		public final String hint; // pista
		/**
		 * Recibe String en formato archivo palabra:pista
		 * @param fileLine
		 */
		
		private SecretWord(String fileLine){
			String value[]=fileLine.split(":");				
			if(value.length==2)
				throw new RuntimeException("The string does not match the : format"); 
				
			this.word=value[0];
			this.hint=value[1]; 
				
		}
	}
	

}
