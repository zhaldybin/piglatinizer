package org.zhaldybin.piglatinizer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinizer {

  private static final Pattern WORD_PATTERN = Pattern.compile("[\\p{Alpha}|']+");
  private static final String VOWELS = "aeiouAEIOU";

  public String latinizeText(final String text) {

    if (text == null || "".equals(text) || Pattern.compile("[^\\p{Alpha}]+").matcher(text).matches()) {
      return text;
    }

    return Arrays.stream(text.split("\n")).map(this::latinizeLine).collect(Collectors.joining("\n"));
  }

  private String latinizeLine(final String line) {

    final StringBuilder lineStringBuilder = new StringBuilder();

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
    final Set<Integer> capitalLetterLocations = new LinkedHashSet<>();
    final StringBuilder wordStringBuilder = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (i == apostropheLocation) continue;
      if (Character.isUpperCase(word.charAt(i))) {
        capitalLetterLocations.add(i);
        wordStringBuilder.append(Character.toLowerCase(word.charAt(i)));
      } else {
        wordStringBuilder.append(word.charAt(i));
      }
    }

    String lowerCaseWord = wordStringBuilder.toString();
    wordStringBuilder.setLength(0);

    if (isVowel(lowerCaseWord.charAt(0))) {
      lowerCaseWord = latinizeWordStartingWithVowel(lowerCaseWord);
    } else {
      lowerCaseWord = latinizeWordStartingWithConsonant(lowerCaseWord);
    }

    for (int i = 0; i < lowerCaseWord.length(); i++) {
      if (apostropheLocation != -1 && ( lowerCaseWord.length() - (word.length() - apostropheLocation) + 1 ) == i ) {
        wordStringBuilder.append("'");
      }
      if (capitalLetterLocations.contains(i)) {
        wordStringBuilder.append(Character.toUpperCase(lowerCaseWord.charAt(i)));
      } else {
        wordStringBuilder.append(lowerCaseWord.charAt(i));
      }
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
