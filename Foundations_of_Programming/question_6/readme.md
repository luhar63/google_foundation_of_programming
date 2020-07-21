## Hangman Part 2: One open source solution

You are required to write a Hangman solver. Testing against [this](https://gist.github.com/adrianiainlam/10152724) English word list\[1\], the solver that solves the most number of words wins, with the number of total incorrect guesses being the tie-breaker. All words in the word list will be tested in random order.

> \[1\]: This word list is taken from [here](http://www.kilgarriff.co.uk/bnc-readme.html), then the numbers are removed, then words with length 1 or with non-alphabetical characters are removed, then the most frequent 4096 unique words are chosen as this word list.

The details:
Your program will interact with the game program, which will give you through stdin the underscores and correctly guessed letters. Your program will give to stdout your guesses, and it has to infer from the input whether the previous guess was right or wrong. After being wrong for 6 times, your program loses. Your program must be ready for the next game after each game ends (after win or loss).

Your code length must be strictly less than 2048 bytes, and your program must not use any external resources (including but not limited to accessing the wordlist on local storage or from the Internet).

Example: (Input is preceded by > here only for clarification - it is not actually present in the input)

```
 > _______ // 7 underscores
 > a // Now you wait for input again
 > _a___a_
 > e
 > _a___a_ // Implies that your guess is wrong \
 > _______ // new round, this will be given ONLY IF you already have 6 losses
```

Suppose you are wrong for 6 times, you will receive a final input which implies your guess is wrong, and your program must be ready to start a new round (i.e. take another input).
If you win,

```
> _angman
> h
> hangman
> _______ // new round After knowing that you have won (because the input has no underscores), you must be ready to accept the next round.
```

Your program must terminate when it receives an input END.

If your program is not deterministic (depends on randomness, pseudorandomness, system time, ambient temperature, my mood etc.), you must explicitly state that in your submission, and your score will be taken 10 times (by me, unless otherwise instructed) and averaged.

Note: if you use languages like python, please explicitly flush your stdout after each print statement.

The game program is as follows (credit to nneonneo):

## Solution

I have tried a greedy approach by pre-processing the given wordlist.txt and extracting the most occurring character in the list of possible words.
Based on the correct guessing, I'll filter out the possible words in every loop.
