import java.io.*;
import java.util.*;

/**
 * I have tried a greedy approach by pre-processing the given wordlist.txt and 
 * extracting the most occurring character in the list of possible words. 
 * Based on the correct guessing, I'll filter out the possible words in every loop.
 */
public class HangmanSolver {
    
    HashMap<Integer, ArrayList<String>> wordsByLength = new HashMap<>();
    ArrayList<String> possibleWords = new ArrayList<String>();
    HashMap<Character, Integer> possibleLetterMap = new HashMap<Character, Integer>();
    PriorityQueue<Character> possibleLetter = new PriorityQueue<Character>((a,b)->possibleLetterMap.get(b)-possibleLetterMap.get(a));
    StringBuilder alreadyGuessed = new StringBuilder();

    public void loadFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner myReader = new Scanner(file);
        while(myReader.hasNextLine()){
            String word = myReader.nextLine();
            Integer length = word.length();
            ArrayList<String> words= wordsByLength.getOrDefault(length, new ArrayList<String>());
            words.add(word);
            wordsByLength.put(length, words);
        }
        myReader.close();
    }
    /**
     * creates a hashmap with key: value as character: counts.
     * Also initializes the priority queue to get most occurring character.
     */
    public void createLetterHashMap(){
        for(String s: possibleWords){
            for(Character c: s.toCharArray()){
                possibleLetterMap.put(c, possibleLetterMap.getOrDefault(c, 0)+1);                
            }
        }
        possibleLetter.addAll(possibleLetterMap.keySet());
    }

    public void resetDictionary(){
        possibleLetterMap = new HashMap<Character, Integer>();
        possibleLetter = new PriorityQueue<Character>((a,b)->possibleLetterMap.get(b)-possibleLetterMap.get(a));
    }

    /**
     * removes unmatched words from possible words list
     * @param word  string provided by hangman program
     * @param lastGuess latest guessed letter
     */

    public void removeWords(String word, Character lastGuess){
        ArrayList<Integer> positions = new ArrayList<Integer>();
        resetDictionary();
        for(int i=0; i<word.length();i++){
            if(word.charAt(i)!='_' && lastGuess.equals(word.charAt(i))){
                positions.add(i);
            }
        }
        ArrayList<String> newPossibleWords = new ArrayList<String>();
        for(String possibleword: possibleWords){
            if(checkForMatchingWord(positions,possibleword,lastGuess)) {
                newPossibleWords.add(possibleword);
                for(Character c: possibleword.toCharArray()){
                    if(alreadyGuessed.toString().indexOf(c)>-1) {
                        continue;
                    } else{
                        possibleLetterMap.put(c, possibleLetterMap.getOrDefault(c, 0)+1);
                    }
                }
            }
        }
        possibleWords = newPossibleWords;
        possibleLetter.addAll(possibleLetterMap.keySet());
    }

    /**
     * it checks if the position of non-underscore letter of string provided by hangman program
     * matches with word of possible words
     * @param positions position of latest guessed letter
     * @param word
     * @param lastGuess
     * @return true: if matches, false: otherwise
     */
    public Boolean checkForMatchingWord(ArrayList<Integer> positions, String word, Character lastGuess){
        for(Integer i: positions){
            if(word.charAt(i)!=lastGuess) {
                return false;
            }
        }
        return true;
    }

    public Character getMostOccurringLetter(){
        return possibleLetter.poll();
    }

    public static void main (String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        HangmanSolver hsolver = new HangmanSolver();
        /** 
         * preprocessing "wordlist.txt" and creating a hashmap where keys are the 
         * length of a word and values is an array of words 
        */
        hsolver.loadFile("wordlist.txt");
        
        while(scan.hasNextLine()){
            Integer counter = 6;
            String inputWord = scan.nextLine();
            Integer wordLength = inputWord.length();
            if(inputWord.equals("END")){
                break;
            }
            hsolver.possibleWords = hsolver.wordsByLength.get(wordLength);
            hsolver.resetDictionary();
            hsolver.alreadyGuessed = new StringBuilder();
            hsolver.createLetterHashMap();
            Character guessedLetter = hsolver.getMostOccurringLetter();
            System.out.println(guessedLetter);
            while(counter > 0 && scan.hasNextLine()) {
                String newInput = scan.nextLine();
                if(newInput.indexOf('_') > -1){
                    hsolver.alreadyGuessed.append(guessedLetter);
                    if(inputWord.equals(newInput)){
                        counter--;
                        if(counter == 0) {
                            break;
                        }
                    } else{
                        inputWord = newInput;
                        hsolver.removeWords(newInput, guessedLetter);
                    }
                    guessedLetter = hsolver.getMostOccurringLetter();
                    System.out.println(guessedLetter);
                } else{
                    break;
                }
            }
        }
        scan.close();
    }
}