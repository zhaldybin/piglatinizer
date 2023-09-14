package org.zhaldybin.piglatinizer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PigLatinizerSentenceTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  void testGivenInputTextIsSentenceWithTwoWordsWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Two Words
    final String input = "hello world";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("ellohay orldway");
  }

  @Test
  void testGivenInputTextIsSentenceWithTwoCapitalizedWordsWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Two Capitalized Words
    final String input = "Hello World";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("Ellohay Orldway");
  }

  @Test
  void testGivenInputTextIsSentenceWithTwoWordsAndPunctuationWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Two Words And Punctuation
    final String input = "Hello, world!";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("Ellohay, orldway!");
  }

  @Test
  void testGivenInputTextIsSentenceWithWordsStartingWithVowelsAndConsonantsWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Words Starting With Vowels And Consonants
    final String input = "hello all";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("ellohay allway");
  }

  @Test
  void testGivenInputTextIsSentenceWithWordWithApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Word With Apostrophe
    final String input = "holiday's special";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("olidaysha'y pecialsay");
  }

  @Test
  void testGivenInputTextIsSentenceWithMultipleWordsAndPunctuationWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Sentence With Multiple Words And Punctuation
    final String input = "The solution often turns out more beautiful than the puzzle.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("Hetay olutionsay oftenway urnstay outway oremay eautifulbay hantay hetay uzzlepay.");
  }

}
