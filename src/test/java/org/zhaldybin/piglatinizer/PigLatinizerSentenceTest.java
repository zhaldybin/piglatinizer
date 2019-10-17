package org.zhaldybin.piglatinizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PigLatinizerSentenceTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  public void testGivenInputTextIsSentenceWithTwoWordsWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Two Words
    final String input = "hello world";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("ellohay orldway"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithTwoCapitalizedWordsWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Two Capitalized Words
    final String input = "Hello World";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Ellohay Orldway"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithTwoWordsAndPunctuationWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Two Words And Punctuation
    final String input = "Hello, world!";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Ellohay, orldway!"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithWordsStartingWithVowelsAndConsonantsWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Words Starting With Vowels And Consonants
    final String input = "hello all";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("ellohay allway"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithWordWithApostropheWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Word With Apostrophe
    final String input = "holiday's special";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("olidaysha'y pecialsay"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithMultipleWordsAndPunctuationWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Multiple Words And Punctuation
    final String input = "The solution often turns out more beautiful than the puzzle.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Hetay olutionsay oftenway urnstay outway oremay eautifulbay hantay hetay uzzlepay."));
  }

}
