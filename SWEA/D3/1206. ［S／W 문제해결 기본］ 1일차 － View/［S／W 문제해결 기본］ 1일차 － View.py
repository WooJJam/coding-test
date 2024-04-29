buildngs = []
for testCase in range(1, 11):
    N = int(input())
    buildngs = list(map(int, input().split()))
    answer = 0
    for i in range(2, len(buildngs)-2):

        # 조망권이 확보된 경우
        if buildngs[i] > buildngs[i-1] and buildngs[i] > buildngs[i-2] and buildngs[i] > buildngs[i+1] and buildngs[i] > buildngs[i+2]:
            answer += min(buildngs[i] - buildngs[i-2], buildngs[i] - buildngs[i-1], buildngs[i] - buildngs[i+1], buildngs[i] - buildngs[i+2])
    print(f"#{testCase} {answer}")