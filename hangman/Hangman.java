package hangman;
import java.util.Scanner;
public class Hangman {
    
       static String[] music = {"scared of the dark", "thunder", "believer", "payphone", "whats up danger"};
       static String[] kitchen = {"dishwasher", "electric stove", "toaster", "refrigerator", "whisk"};
       static String[] hintMusic = {"Spider-verse OST.", "Lightning and the ...", "Artist: Imagine Dragons", "... trying to call home", "Spider-verse OST."};
       static String[] HintKithen = {"Clean dish", "Heat up the food", "Hot bread", "24 hours power comsumption", "100%, ever man are scared of this"};   
       static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {        
        inputSet();
    }
    
    public static void inputSet(){
       
        System.out.println("Welcome to Hangman game");
        System.out.println("Select Category:");
        System.out.println("1. Music");
        System.out.println("2. kitchen");
        
       System.out.print("> ");
       int setWord = sc.nextInt();
       playSet(setWord);
    }
    
    public static void playSet(int set){   
        String []playG = new String[5];
        String []hintPlayG = new String[5];
        if(set == 1){
            playG = music;
            hintPlayG = hintMusic;
            start(playG, hintPlayG);
        }else if(set == 2){
            playG = kitchen;
            hintPlayG = HintKithen;
            start(playG, hintPlayG);
        }else
        {
            inputSet();
        }        
    }
    
    
     static String[] showWord;
     static String hint;
     static String word;
     static String wrongG = "";
     static int score = 0;
     
      public static void start(String[] playG, String[] hintPlayG){ 
           int w = (int)(Math.random() * playG.length) + 0;
            word = playG[w];        
            hint = hintPlayG[w];
            
            
           int h = (int)(Math.random() * playG.length) + 0; 

            showWord = new String[word.length()];
            
            for (int i = 0; i < word.length(); i++) {
             if(word.charAt(i) == ' '){
                showWord[i] = " ";
             }else{
                showWord[i] = "_";
             }
             
             if(i == h){
                 if(word.charAt(i) == ' '){
                     start(playG, hintPlayG);
                 }
                    showWord[i] = ""+word.charAt(i);
             }
             
         }
         System.out.println("HINT: "+hint);
         System.out.println();
         show();  
         
         while (win == false) {
            game();
         }
          System.out.println("You Win :"+score);
          if(score < 0){
              System.out.println("so this is the first time you play huh? you noob :/");
          }
          System.out.println("wanna play again?");
          System.out.println("Y/N");
          String again = sc.next().toLowerCase();
          if(again.equals("y")){
              inputSet();
          }
    }
      public static void show(){
          System.out.println();
        for(String a:showWord){
            System.out.print(a);
            System.out.print(" ");            
         }
          System.out.print("\t Score :"+score);
        if(wrongG != ""){
          System.out.print(", wrong guessed1:"+wrongG);
          System.out.println();
        }else{
            System.out.println();
        }
      }
      
      static boolean win = false;
      public static void game(){
        System.out.print("> ");
        String w = sc.next().toLowerCase();
        while (w.length() > 1 ) {
            System.out.print("> ");
            w = sc.next();
        }
        
        boolean found = false;
        boolean dup = false;
          for (int i = 0; i < word.length(); i++) {
             if(word.charAt(i) == w.charAt(0)){
                 found = true;
                 if (showWord[i].equals(w)) {       // duplicate
                     dup = true;
                 }
                 else { 
                    showWord[i] = w;
                    score += 10; 
                 }
             }
          }
          if(found == false){
              wrongG = wrongG+w+" "; 
              score -= 10;
          }
          boolean hasKeed = false;
          for(String a:showWord){
              if(a.equals("_")){
                  hasKeed = true;
              }
          }
          win = !hasKeed;
        show();
      }
 }
      
   

