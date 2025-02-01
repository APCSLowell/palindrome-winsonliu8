import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
  public void tester()
  {
    //String lines[] = loadStrings("palindromes.txt");
    String[] lines = new String[6];
    try {
      File myFile = new File("palindromes.txt");
      Scanner myReader = new Scanner(myFile);
      int counter = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines[counter] = data;
        counter++;
      }
      myReader.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("there are " + lines.length + " lines");
    for (int i=0; i < lines.length; i++)
    {
      if (palindrome(lines[i])==true)
      {
        System.out.println(lines[i] + " IS a palindrome.");
      } else
      {
        System.out.println(lines[i] + " is NOT a palindrome.");
      }
    }
  }
  public boolean palindrome(String word) //check if is palindrome
  {
    String every = onlyLetters(noCapitals(noSpaces(word)));
    String backwards = reverse(every);
    return every.equals(backwards);
  }
  public String reverse(String word) //make reverse
  {
    String sNew = new String();
    for (int i = word.length()-1; i >= 0; i--)
      sNew = sNew + word.charAt (i);

    return sNew;
  }
  public String noCapitals(String sWord) { //return string with all lowercase
    return sWord.toLowerCase();
  }
  public String noSpaces(String sWord) { //return string with no spaces
    String s = "";
    for (int i = 0; i < sWord.length(); i++)
      if (!sWord.substring (i, i+1).equals (" "))
        s = s + sWord.charAt(i);

    return s;
  }
  public String onlyLetters(String word) { //return only letters
    String s = "";
    for (int i = 0; i < word.length(); i++)
      if (Character.isLetter(word.charAt(i)))
        s = s + word.charAt(i);
    return s;
  }
}



