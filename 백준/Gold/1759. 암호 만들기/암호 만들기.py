import itertools

L, C = map(int, input().split())
words = list(map(str, input().split()))
words.sort()
for word in itertools.combinations(words, L):
    count = word.count("a") + word.count("e") + word.count("i") + word.count("o") + word.count("u")
    check = L - count
    if count >= 1 and check >= 2:
        for i in word:
            print(i, end="")
        print()