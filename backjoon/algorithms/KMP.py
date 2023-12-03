# KMP (Knuth-Morris-Pratt)
# 문자열 검색 알고리즘
# 길이가 N 인 문자열에서 길이가 M인 문자열을 찾는 과정이라는 가정 하에,
    # Brute force : O(N*M)
    # KMP : O(N+M)

def make_KMP_table(pattern):
    pattern_len = len(pattern)
    kmp_table = [0 for _ in range(pattern_len)]

    prev_idx = 0
    for idx in range(1, pattern_len):
        while prev_idx > 0 and pattern[idx] != pattern[prev_idx]:
            prev_idx = kmp_table[prev_idx-1]
        if pattern[idx] == pattern[prev_idx]:
            prev_idx += 1
            kmp_table[idx] = prev_idx
    return kmp_table

def KMP(parent, pattern):
    kmp_table = make_KMP_table(pattern)
    parent_size = len(parent)
    pattern_size = len(pattern)
    j = 0

    for i in range(parent_size):
        while j>0 and parent[i] != pattern[j]:
            j = kmp_table[j-1]
        if parent[i] == pattern[j]:
            if j == pattern_size-1:
                print(i-pattern_size+2, "번째 에서 발견")
                j = kmp_table[j]
            else:
                j += 1

parent = "ababacabacaabacaaba"
pattern = "abacaaba"
KMP(parent,pattern)
