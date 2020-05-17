#!/usr/bin/env python
import collections
import sys


def find_longest_word_in_string(letters, words):
    letter_positions = {}
    for index, letter in enumerate(letters):
        if letter not in letter_positions:
            letter_positions[letter] = []
        letter_positions[letter].append(index)
    for word in sorted(words, key=lambda w: len(w), reverse=True):
        head = 0
        flag = False
        for letter in word:
            next_position = []
            if letter not in letter_positions:
                flag = True
                break
            for p in letter_positions[letter]:
                if p >= head:
                    next_position.append(p)
            if len(next_position) == 0:
                flag = True
                break
            head = next_position[0] + 1

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
