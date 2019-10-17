package org.zhaldybin.piglatinizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PigLatinizerParagraphTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  public void testGivenInputTextIsParagraphWithTwoSentencesWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Paragraph With Two Sentences
    // @formatter:off
    final String input = "This is the first line of text,\n"
                       + "and here goes the second one!";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result, is("Histay isway hetay irstfay inelay ofway exttay,\n"
                              + "andway erehay oesgay hetay econdsay oneway!"));
    // @formatter:on
  }

  @Test
  public void testGivenInputTextIsParagraphWithTwoSentencesAndNewLineAtTheBeginningWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Paragraph With Two Sentences And New Line At The Beginning
    // @formatter:off
    final String input = "\nThis is the first line of text,\n"
                       + "and here goes the second one!";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result, is("\nHistay isway hetay irstfay inelay ofway exttay,\n"
                              + "andway erehay oesgay hetay econdsay oneway!"));
    // @formatter:on
  }

  @Test
  public void testGivenInputTextIsParagraphWithTwoSentencesAndAnEmptyLineInBetweenWhenLatinizeTextIsCalledThenOutputIsExpected() {

    // Given Input Text Is Paragraph With Two Sentences And An Empty Line In Between
    // @formatter:off
    final String input = "This is the first line of text,\n\n"
                       + "and here goes the second one!";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result, is("Histay isway hetay irstfay inelay ofway exttay,\n\n"
                              + "andway erehay oesgay hetay econdsay oneway!"));
    // @formatter:on
  }

}