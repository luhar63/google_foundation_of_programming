#!/usr/bin/env python
import collections
import sys


def decompression(compressedWords):
    def decompressUtil(repetition, words):
        res = ""
        i = 0
        while i < len(words):
            if (ord(words[i]) >= ord("0") and ord(words[i]) <= ord("9")) or (
                words[i] == "["
            ):
                rep = 0
                while i < len(words) and words[i] != "[":
                    rep = rep * 10 + int(words[i])
                    i += 1

                bracket = 0
                k = i + 1
                while i < len(words):
                    if words[i] == "[":
                        bracket += 1
                    if words[i] == "]":
                        bracket -= 1
                    if bracket == 0:
                        break
                    i += 1
                res += decompressUtil(rep, words[k:i])
                i += 1
            else:
                res += words[i]
                i += 1
        return res * repetition

    return decompressUtil(1, "1[" + compressedWords + "]")


if __name__ == "__main__":
    print(decompression("3[abc]4[ab]"))
    print(decompression("1[abc]"))
    print(decompression("2[3[a]b]"))
    print(decompression("a[3[c]]b"))
    print(
        decompression("1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[1[xx]]]]]]]]]]]]]]]]]]]]")
    )
