package org.zhaldybin.piglatinizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PigLatinizerWordTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  public void testGivenInputTextIsEmptyStringWhenLatinizeTextIsCalledThenResultIsEmptyString() {

    // Given Input Text Is Empty String
    final String input = "";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Empty String
    assertThat(result, is(""));
  }

  @Test
  public void testGivenInputTextIsBlankStringWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Blank String
    final String input = "   ";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result, is(input));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithConsonantWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant
    final String input = "hello";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("ellohay"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithVowelWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel
    final String input = "apple";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("appleway"));
  }

  @Test
  public void testGivenInputTextIsWordEndingWithWayWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Word Ending With Way
    final String input = "stairway";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result, is(input));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithConsonantAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Containing Apostrophe
    final String input = "can't";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("antca'y"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithVowelAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Containing Apostrophe
    final String input = "apple's";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("appleswa'y"));
  }

  @Test
  public void testGivenInputTextIsWordEndingWithWayAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Word Ending With Way And Containing Apostrophe
    final String input = "stair'way";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result, is(input));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithConsonantAndEndingWithApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Ending With Apostrophe
    final String input = "cats'";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("atscay'"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithVowelAndEndingWithApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Ending With Apostrophe
    final String input = "apples'";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("applesway'"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithConsonantAndEndingWithDotWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Ending With Dot
    final String input = "hello.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("ellohay."));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithVowelAndEndingWithDotWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Ending With Dot
    final String input = "apple.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("appleway."));
  }

  @Test
  public void testGivenInputTextContainsHyphenWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Contains Hyphen
    final String input = "this-thing";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("histay-hingtay"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithUpperCaseConsonantWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Upper Case Consonant
    final String input = "Beach";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Eachbay"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithUpperCaseVowelWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Upper Case Vowel
    final String input = "Apple";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("Appleway"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithConsonantAndContainingMultipleUpperCaseLettersWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Containing Multiple Upper Case Letters
    final String input = "McCloud";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("CcLoudmay"));
  }

  @Test
  public void testGivenInputTextIsWordStartingWithVowelAndContainingMultipleUpperCaseLettersWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Containing Multiple Upper Case Letters
    final String input = "ApplesOranges";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result, is("ApplesOrangesway"));
  }

}
