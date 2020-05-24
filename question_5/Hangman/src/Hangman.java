import java.util.*;
import java.util.stream.Collectors;

import acm.program.*;

public class Hangman extends ConsoleProgram{
    HashMap<Character, ArrayList<Integer>> wordMapToBeGuessed = new HashMap<Character, ArrayList<Integer>>() ;
    ArrayList<Character> hiddenWord = new ArrayList<Character>();
    String word;
    private HangmanCanvas canvas;
    public void pickAWord(){
        HangmanLexicon hl = new HangmanLexicon();
        Random rand = new Random();
        String wordToBeGuessed = hl.getWord(rand.nextInt(hl.getWordCount()));
        word = wordToBeGuessed;
        for(int i=0; i<wordToBeGuessed.toCharArray().length; i++){
            Character c = wordToBeGuessed.charAt(i);
            ArrayList<Integer> char_counter = wordMapToBeGuessed.getOrDefault(c, new ArrayList<Integer>());
            char_counter.add(i);
            wordMapToBeGuessed.put(c, char_counter);
            hiddenWord.add('-');
        }
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }

    public void run() {
    	println("Welcome to Hangman!!");
        pickAWord();
        Boolean finished = false;
        Integer number_of_guesses = 8;
        Integer guessed_total = 0;
        canvas.reset();
        while(!finished) {
            String hiddenWordString = hiddenWord.stream().map(e->e.toString()).collect(Collectors.joining());
            canvas.displayWord(hiddenWordString);
            println("The word now looks like this: " + hiddenWordString);
            if(number_of_guesses > 1) {
                println("You have " + number_of_guesses + " guesses left.");
            } else {
                println("You have only one guess left.");
            }
            
            String input = readLine("Your guess: ");
            while (true) {
                if(input.length() > 1) {
                    input = readLine("You can only guess one letter at a time. Try again: ");
                }
                if(input.length() == 1) break;
            }
            Character guessedLetter = input.charAt(0);
            if(Character.isAlphabetic(guessedLetter)){
                Character upper_GL = Character.toUpperCase(guessedLetter);
                if(wordMapToBeGuessed.containsKey(upper_GL)){
                    ArrayList<Integer> indexList = wordMapToBeGuessed.get(upper_GL);
                    if(indexList.size() > 0) {
                        println("That guess is correct.");
                    } else {
                        println("You have already guessed it.");
                    }
                    for(Integer index: indexList){
                        hiddenWord.set(index, upper_GL);
                        guessed_total++;
                    }
                    wordMapToBeGuessed.put(upper_GL, new ArrayList<Integer>());
                    if(guessed_total == word.length()){
                        println("You guessed the word: " + word);
                        println("You win");
                        finished = true;
                    }
                } else{
                    number_of_guesses--;
                    canvas.noteIncorrectGuess("There are no " + upper_GL +"'s in the word", 8-number_of_guesses);
                    println("There are no " + upper_GL +"'s in the word");
                    if(number_of_guesses == 0){
                        println("You are completely hung.");
                        println("The word was : " + word);
                        println("You Lose");
                        finished = true;
                    }
                }
                
            } else{
                println("Please enter an alphabet.");
            }
            
           
        }
	}
    // public static void main(String[] arg){
    //     Hangman game = new Hangman();
    //     game.run();
    // }
}