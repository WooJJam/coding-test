N, W, L = map(int, input().split())
car = list(map(int, input().split()))

answer = car[0]
bridge = [0] * W
time = 0

while bridge:
    time += 1
    bridge.pop(0)
    if car:
        if sum(bridge) + car[0] <= L:
            bridge.append(car.pop(0))
        else :
            bridge.append(0)
print(time)