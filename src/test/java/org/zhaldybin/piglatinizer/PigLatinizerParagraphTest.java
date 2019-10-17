package org.zhaldybin.piglatinizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class PigLatinizerParagraphTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  public void testGivenInputTextIsParagraphWithTwoLinesWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines
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
  public void testGivenInputTextIsParagraphWithTwoLinesAndNewLineAtTheBeginningWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines And New Line At The Beginning
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
  public void testGivenInputTextIsParagraphWithTwoLinesAndAnEmptyLineInBetweenWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines And An Empty Line In Between
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

  @Test
  public void testGivenTextWithMultipleParagraphsWhenLatinizeTextIsCalledThenResultIsExpected() throws Exception {

    // Given Text With Multiple Paragraphs
    final String content = readFileContent("paragraph.txt");

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(content);

    // Then Result Is Expected
    assertThat(result, is(readFileContent("latinizedParagraph.txt")));
  }

  private String readFileContent(final String fileName) throws URISyntaxException, IOException {

    return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));
  }

}
