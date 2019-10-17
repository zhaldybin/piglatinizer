package org.zhaldybin.piglatinizer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * Translate a string into "pig-latin".
 * </p>
 * <p>
 * The following rules apply when translating a string:
 * <ul>
 *   <li>Words that start with a consonant have their first letter moved to the end of the word and the letters “ay”
 *       added to the end</li>
 *   <li>Words that start with a vowel have the letters “way” added to the end</li>
 *   <li>Words that end in “way” are not modified</li>
 *   <li>Punctuation must remain in the same relative place from the end of the word</li>
 *   <li>Hyphens are treated as two words</li>
 *   <li>Capitalization must remain in the same place</li>
 * </ul>
 * </p>
 *
 * @author Leonid Zhaldybin
 */
public class PigLatinizer {

  private static final Pattern WORD_PATTERN = Pattern.compile("[\\p{Alpha}|']+");
  private static final String VOWELS = "aeiouAEIOU";

  public String latinizeText(final String text) {

    // if text is an empty string or contains no alphabetic characters, return immediately
    if (text == null || "".equals(text) || Pattern.compile("[^\\p{Alpha}]+").matcher(text).matches()) {
      return text;
    }

    return Arrays.stream(text.split("\n")).map(this::latinizeLine).collect(Collectors.joining("\n"));
  }

  private String latinizeLine(final String line) {

    final StringBuilder lineStringBuilder = new StringBuilder();

    // split line into chunks which contain either words (alphabetic characters plus apostrophe)
    // or sequences of non-alphabetic characters
    final Pattern wordOrDelimiterPattern = Pattern.compile("[\\p{Alpha}|']+|[^\\p{Alpha}]+");
    final Matcher wordOrDelimiterMatcher = wordOrDelimiterPattern.matcher(line);
    while (wordOrDelimiterMatcher.find()) {
      String word = wordOrDelimiterMatcher.group(0);
      if (WORD_PATTERN.matcher(word).matches()) {
        word = latinizeWord(word);
      }
      lineStringBuilder.append(word);
    }

    return lineStringBuilder.toString();
  }

  private String latinizeWord(final String word) {

    if (word.endsWith("way")) {
      return word;
    }

    final int apostropheLocation = word.indexOf("'");
    final Set<Integer> capitalLetterLocations = new HashSet<>();
    final StringBuilder wordStringBuilder = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (i == apostropheLocation) {
        continue;
      }
      if (Character.isUpperCase(word.charAt(i))) {
        capitalLetterLocations.add(i);
        wordStringBuilder.append(Character.toLowerCase(word.charAt(i)));
      } else {
        wordStringBuilder.append(word.charAt(i));
      }
    }

    String lowerCaseWord = wordStringBuilder.toString();
    wordStringBuilder.setLength(0);

    final String lowerCaseLatinizedWord;
    if (isVowel(lowerCaseWord.charAt(0))) {
      lowerCaseLatinizedWord = latinizeWordStartingWithVowel(lowerCaseWord);
    } else {
      lowerCaseLatinizedWord = latinizeWordStartingWithConsonant(lowerCaseWord);
    }

    final int apostropheLocationInResult =
        apostropheLocation == -1 ? -1 : lowerCaseLatinizedWord.length() - (word.length() - apostropheLocation) + 1;
    for (int i = 0; i < lowerCaseLatinizedWord.length(); i++) {
      if (apostropheLocationInResult == i) {
        wordStringBuilder.append("'");
      }
      if (capitalLetterLocations.contains(i)) {
        wordStringBuilder.append(Character.toUpperCase(lowerCaseLatinizedWord.charAt(i)));
      } else {
        wordStringBuilder.append(lowerCaseLatinizedWord.charAt(i));
      }
    }

    // TODO: Come up with a better solution for this special case
    if (word.endsWith("'")) {
      wordStringBuilder.append("'");
    }

    return wordStringBuilder.toString();
  }

  private String latinizeWordStartingWithVowel(final String word) {
    return word + "way";
  }

  private String latinizeWordStartingWithConsonant(final String word) {
    return word.substring(1) + word.substring(0, 1) + "ay";
  }

  private boolean isVowel(final char character) {
    return VOWELS.contains(String.valueOf(character));
  }
}
