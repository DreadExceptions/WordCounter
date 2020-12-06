# WordCounter
A little java program that counts words and syllables.
Currently, the program utilizes a simple algorithm that counts vowel groups to calculate syllables. It also counts total and unique words, as well as the average number of syllables per word. It does all of this from an ODF file given to it.
Fancy algorithms utilized include:
1. Binary Search that either inserts a new word or adds to the frequency of the word.
2. Merge Sort that has been written so it can either alphabetize or sort by frequency.

## To Do
Currently, the only very major part left is a more accurate method to count syllables in each word. This might be implemented either through hyphenation algorithms, a dictionary search, or a neural network trained. Either way, all things to fix are listed below.
1. Allow for apostrophes in the regex search.
2. GUI input for file paths
3. Ignore 100 most common words
4. Longer document sizes
5. More accurate syllable counting
