package chapter2.item5;

public class SpellChecker {

  private static final Lexicon dictionary = new Lexicon();

  private SpellChecker() {

  }

  public static SpellChecker INSTANCE = new SpellChecker();

  public boolean isValid(String word) {
    return true;
  }

}
