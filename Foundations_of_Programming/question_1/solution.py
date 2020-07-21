#!/usr/bin/env python
import collections
import sys


def find_longest_word_in_string(letters, words):
    letter_positions = {}
    # preprocessing the big word  : every letter with their position in the word
    for index, letter in enumerate(letters):
        if letter not in letter_positions:
            letter_positions[letter] = []
        letter_positions[letter].append(index)
    # sort the dictionary in decsending order of their length
    for word in sorted(words, key=lambda w: len(w), reverse=True):
        position = 0
        # position of letter where next letter can be found
        flag = False
        # keeping the flag if dictionary word fail to be a subsequence; True - failed to be subsequence, False - might be subsequence
        for letter in word:
            next_position = []
            if letter not in letter_positions:
                flag = True
                break
            for p in letter_positions[letter]:
                if p >= position:
                    next_position.append(p)
            if len(next_position) == 0:
                flag = True
                break
            position = next_position[0] + 1

        if not flag:
            return word


if __name__ == "__main__":
    print(
        find_longest_word_in_string(
            "abppplee", ["able", "ale", "apple", "bale", "kangaroo"]
        )
    )
    print(
        find_longest_word_in_string(
            "biagedinsbgeerabredagfeafadsmdfufdfdfki ng",
            ["larry", "gingerbreadmuffin", "egg", "bibles", "love"],
        )
    )
