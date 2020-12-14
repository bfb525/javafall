import java.util.*;
public class HangmanGame{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a 4 letter word");
    String word = input.next();
    
    //Uses toUpperCase method to convert each char in String.
    int index = 0;
    while (word.length() > index) {
      toUpperCase(word.charAt(index));
      index++; 
    }
    
    runGame(word.toUpperCase()); //Runs game with string word
  }
  
  /*
   Method creates booleans, false, for each letter. Loops input requests for a char. 
   */
  public static void runGame(String word){
    Scanner input = new Scanner(System.in);
    int nOMisses = 0;
    int nCorrect = 0;
    boolean pos1 = false;
    boolean pos2 = false;
    boolean pos3 = false;
    boolean pos4 = false;
    
    //If either user reaches 6 wrong or 4 correct, loop ends.
    while (nOMisses < 6){
      System.out.println("Enter letter");
      char c = input.next().charAt(0);
      
      /*For each question, converts both String and char to upper case. Then, compares letter's index in string to
      user's input using method isLetterInWord. Increments number of correct guesses if true, followed by printing 
      user's progress. */
      if (isLetterInWord(word, toUpperCase(c)) == 0){
        pos1 = true;
        printHanging(nOMisses);
        printWord(word, pos1, pos2, pos3, pos4);
        nCorrect++;
      }
      else if (isLetterInWord(word, toUpperCase(c)) == 1){
        pos2 = true;
        printHanging(nOMisses);
        printWord(word, pos1, pos2, pos3, pos4);
        nCorrect++;
      }
      else if (isLetterInWord(word, toUpperCase(c)) == 2){
        pos3 = true;
        printHanging(nOMisses);
        printWord(word, pos1, pos2, pos3, pos4);
        nCorrect++;
      }
      else if (isLetterInWord(word, toUpperCase(c)) == 3){
        pos4 = true;
        printHanging(nOMisses);
        printWord(word, pos1, pos2, pos3, pos4);
        nCorrect++;
      }
      //If user input does not correspond to char in String, increment number of misses, then printing user's progress.
      else {
        nOMisses++;
        printHanging(nOMisses);
        printWord(word, pos1, pos2, pos3, pos4);
      }  
      //Ends loop if user reaches 4 correct.
      if (nCorrect == 4) { 
        nOMisses = 6;
      }
    }
    //Prints winning message if all four guesses evaluate to true.
    if (pos1 && pos2 && pos3 && pos4) {
      System.out.println("You win.");
    }
    //Prints losing message, assuming that less than four guesses are true and 6 misses are reached.
    else {
      System.out.println("You lose");
    }
  }
  
  /*
  Method to return index of char inputted by user (0-3) if char appears in String. If char does not appear in String,
  */
  
  //return -1. 
  public static int isLetterInWord(String word, char c){ 
    /* Loops until number of verified letters is equal to length of word. Returns index of letter in String if present
    and makes call to toUpperCase method to convert each char to uppercase. Otherwise, returns -1. */
    int index = 0;
    while (word.length() > index) {
      if (word.charAt(index) == c) {
        return index;
      }
      index++;
    }
    return -1;
  }
  
  //Method to convert all lowercase chars inputed by user to uppercase.
  public static char toUpperCase(char c){
    if ((c >= 'a') && (c <= 'z')){
      c = (char)(c - 32);
    }
    return c;
  }

  /* 
  printHanging takes as input the number of misses the player has made,
  and prints out the hangman corresponding to the number of misses they have made
  printHanging does not return any values 
  */
  public static void printHanging(int misses){
    //Initially, no part of the hangman should be drawn, leave blank spaces for each
    String head = " ", body = " ", larm = " ", rarm = " ", lleg = " ", rleg = " ";
    switch (misses){
      default: head = "0"; //After making 6 or more misses, we add on the head - the player has lost
      case 5: rleg = "\\"; //After making 5 or more misses, we draw the right leg
      case 4: lleg = "/";  //After making 4 or more misses, we draw the left leg
      case 3: rarm = "\\"; //After making 3 or more misses, we draw the right arm
      case 2: larm = "/";  //After making 2 or more misses, we draw the left arm
      case 1: body = "|";  //After making 1 or more misses, we draw the left arm
      case 0: ;            //With 0 misses, nothing should be drawn
    }    
    //Print statement which draws the hangman
    System.out.println("___________\n" +
                       "|         |\n" +
                       "|         " + head +"\n" +
                       "|        " + larm + body + rarm + "\n" +
                       "|       " + larm + " " + body + " " + rarm + "\n" +
                       "|        " + lleg + " " + rleg + "\n" +
                       "|       " + lleg + "   " + rleg + "\n" +
                       "|__________\n");
   }
  
  
  
  /* 
   printWord prints the 4 letter word based on which letters have been correctly guessed.
  It takes as input the String corresponding to the word being guessed,
  as well as a boolean value for each letter in the word - representing whether or not that
  particular letter has been guessed yet. 
  */
  public static void printWord(String word, boolean pos0, boolean pos1, boolean pos2, boolean pos3){
    //if letter at position 0 has been guessed, print the character at position 0, otherwise print _
    if(pos0){
      System.out.print(" " + word.charAt(0) + " ");
    }else{
      System.out.print(" _ ");
    }
    //if letter at position 1 has been guessed, print the character at position 1, otherwise print _
    if(pos1){
      System.out.print(" " + word.charAt(1) + " ");
    }else{
      System.out.print(" _ ");
    }
    //if letter at position 2 has been guessed, print the character at position 2, otherwise print _
    if(pos2){
      System.out.print(" " + word.charAt(2) + " ");
    }else{
      System.out.print(" _ ");
    }
    
    //if letter at position 3 has been guessed, print the character at position 3, otherwise print _
    if (pos3){
      System.out.println(" " + word.charAt(3) + " ");
    }else{
      System.out.println(" _ ");
    }   
  }  
}

