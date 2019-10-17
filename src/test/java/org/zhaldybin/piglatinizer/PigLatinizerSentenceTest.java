package org.zhaldybin.piglatinizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PigLatinizerSentenceTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  public void testGivenInputTextIsSentenceWithTwoWordsWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Two Words
    final String input = "Hello World";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Ellohay Orldway"));
  }

  @Test
  public void testGivenInputTextIsSentenceWithTwoWordsAndPunctuationWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Sentence With Two Words And Punctuation
    final String input = "Hello, World!";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Ellohay, Orldway!"));
  }


}
