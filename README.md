# Pig Latinizer

Java code that translates a string (word, sentence, or paragraph) into “pig Latin” according to the following rules:
* Words that start with a consonant have their first letter moved to the end of the word and the letters “ay” added to the end: ```hello``` -> ```ellohay```.
* Words that start with a vowel have the letters “way” added to the end: ```apple``` -> ```appleway```.
* Words that end in “way” are not modified: ```stairway``` -> ```stairway```.
* Punctuation must remain in the same relative place from the end of the word: ```can't``` -> ```antca'y```, ```end.``` -> ```endway.```
* Hyphens are treated as two words: ```this-thing``` -> ```histay-hingtay```.
* Capitalization remains in place: ```Beach``` -> ```Eachbay```, ```McCloud``` -> ```CcLoudmay```.

The code assumes that input is a valid text in English language, meaning that words consist of alphabetic characters and apostrophes, a word can contain at most one apostrophe.

The tests can be executed using Maven:
```mvn clean test```
