package main;

import java.util.ArrayList;


import util.FileHelper;

public class Dictionary {
	private ArrayList<SecretWord> list;

	final String FILE_NAME;
	
	public Dictionary(String fileDictionary){
		FILE_NAME=fileDictionary;
		loadWordsFromFile();
	}
	
	
	/**
	 * Carga todo el diccionario de palabras desde el fichero
	 */
	private void loadWordsFromFile(){
		
		String words[] = FileHelper.readFile(this.FILE_NAME);
		list = new ArrayList<SecretWord>(words.length); 
		
	
		for (String line: words){
			list.add(new SecretWord(line));
		}
	}
	
	
	/**
	 * retorna una palabra seleccionada aleatoriamente del arreglo newWord
	 * si no hay mas palabras disponibles en newWord, reinicia los arreglos. 
	 * es decir carga nuevamente las palabras desde el fichero con loadWords()
	 * @return
	 */
	public SecretWord getNextWord(){
		
		if (list.size()==0){
			loadWordsFromFile();
		}
	
		int index=(int) (list.size()*(Math.random()));
		
		SecretWord palabra = list.get(index); 
		removeFromNewWords(index); 
		
		return  palabra;  
	}
	
	private void removeFromNewWords(int index) {
		//ArrayList<SecretWord> reducedList = new ArrayList<SecretWord>(list.size()-1);
		
		
		//String[] reducedNewWord=new String[list.length-1];
		
		if(index<0 || index>=list.size()) return;
		/*
		int j=0;
		
		for (int i=0; i<list.size(); i++){
			if(i!=index){
				reducedList.set(i, list.get(i));
				j++;
			}
		}
		list=reducedList;*/
		list.remove(index);
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
			if(value.length!=2)
				throw new RuntimeException("The string does not match the : format"); 
				
			this.word=value[0];
			this.hint=value[1]; 
				
		}
	}
	
}
