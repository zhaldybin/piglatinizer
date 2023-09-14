package org.zhaldybin.piglatinizer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PigLatinizerWordTest {

  private static final PigLatinizer LATINIZER = new PigLatinizer();

  @Test
  void testGivenInputTextIsEmptyStringWhenLatinizeTextIsCalledThenResultIsEmptyString() {

    // Given Input Text Is Empty String
    final String input = "";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Empty String
    assertThat(result).isEmpty();
  }

  @Test
  void testGivenInputTextIsBlankStringWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Blank String
    final String input = "   ";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result).isEqualTo(input);
  }

  @Test
  void testGivenInputTextIsWordStartingWithConsonantWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant
    final String input = "hello";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("ellohay");
  }

  @Test
  void testGivenInputTextIsWordStartingWithVowelWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel
    final String input = "apple";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("appleway");
  }

  @Test
  void testGivenInputTextIsWordEndingWithWayWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Word Ending With Way
    final String input = "stairway";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result).isEqualTo(input);
  }

  @Test
  void testGivenInputTextIsWordStartingWithConsonantAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Containing Apostrophe
    final String input = "can't";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("antca'y");
  }

  @Test
  void testGivenInputTextIsWordStartingWithVowelAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Containing Apostrophe
    final String input = "apple's";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("appleswa'y");
  }

  @Test
  void testGivenInputTextIsWordEndingWithWayAndContainingApostropheWhenLatinizeTextIsCalledThenResultIsSameAsInput() {

    // Given Input Text Is Word Ending With Way And Containing Apostrophe
    final String input = "stair'way";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Same As Input
    assertThat(result).isEqualTo(input);
  }

  @Test
  void testGivenInputTextIsWordStartingWithConsonantAndEndingWithApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Ending With Apostrophe
    final String input = "cats'";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("atscay'");
  }

  @Test
  void testGivenInputTextIsWordStartingWithVowelAndEndingWithApostropheWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Ending With Apostrophe
    final String input = "apples'";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("applesway'");
  }

  @Test
  void testGivenInputTextIsWordStartingWithConsonantAndEndingWithDotWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Ending With Dot
    final String input = "hello.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("ellohay.");
  }

  @Test
  void testGivenInputTextIsWordStartingWithVowelAndEndingWithDotWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Ending With Dot
    final String input = "apple.";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("appleway.");
  }

  @Test
  void testGivenInputTextContainsHyphenWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Contains Hyphen
    final String input = "this-thing";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("histay-hingtay");
  }

  @Test
  void testGivenInputTextIsWordStartingWithUpperCaseConsonantWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Upper Case Consonant
    final String input = "Beach";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("Eachbay");
  }

  @Test
  void testGivenInputTextIsWordStartingWithUpperCaseVowelWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Upper Case Vowel
    final String input = "Apple";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("Appleway");
  }

  @Test
  void testGivenInputTextIsWordStartingWithConsonantAndContainingMultipleUpperCaseLettersWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Consonant And Containing Multiple Upper Case Letters
    final String input = "McCloud";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("CcLoudmay");
  }

  @Test
  void testGivenInputTextIsWordStartingWithVowelAndContainingMultipleUpperCaseLettersWhenLatinizeTextIsCalledThenResultIsExpected() {

    // Given Input Text Is Word Starting With Vowel And Containing Multiple Upper Case Letters
    final String input = "ApplesOranges";

    // When Latinize Text Is Called
    final String result = LATINIZER.latinizeText(input);

    // Then Result Is Expected
    assertThat(result).isEqualTo("ApplesOrangesway");
  }

}
