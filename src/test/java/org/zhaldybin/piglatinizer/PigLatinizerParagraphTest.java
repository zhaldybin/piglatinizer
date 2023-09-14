package org.zhaldybin.piglatinizer;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class PigLatinizerParagraphTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  void testGivenInputTextIsParagraphWithTwoLinesWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines
    // @formatter:off
    final String input = """
                       This is the first line of text,
                       and here goes the second one!""";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result).isEqualTo("""
                                 Histay isway hetay irstfay inelay ofway exttay,
                                 andway erehay oesgay hetay econdsay oneway!""");
    // @formatter:on
  }

  @Test
  void testGivenInputTextIsParagraphWithTwoLinesAndNewLineAtTheBeginningWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines And New Line At The Beginning
    // @formatter:off
    final String input = """

This is the first line of text,
and here goes the second one!""";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result).isEqualTo("""

Histay isway hetay irstfay inelay ofway exttay,
andway erehay oesgay hetay econdsay oneway!""");
    // @formatter:on
  }

  @Test
  void testGivenInputTextIsParagraphWithTwoLinesAndAnEmptyLineInBetweenWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Paragraph With Two Lines And An Empty Line In Between
    // @formatter:off
    final String input = """
This is the first line of text,

and here goes the second one!""";
    // @formatter:on

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    // @formatter:off
    assertThat(result).isEqualTo("""
Histay isway hetay irstfay inelay ofway exttay,

andway erehay oesgay hetay econdsay oneway!""");
    // @formatter:on
  }

  @Test
  void testGivenTextWithMultipleParagraphsWhenLatinizeTextIsCalledThenResultIsExpected() throws Exception {

    // Given Text With Multiple Paragraphs
    final String content = readFileContent("paragraph.txt");

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(content);

    // Then Result Is Expected
    assertThat(result).isEqualTo(readFileContent("latinizedParagraph.txt"));
  }

  private String readFileContent(final String fileName) throws URISyntaxException, IOException {

    return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));
  }

}
