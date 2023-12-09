import sys
room = []
n, atk = map(int, sys.stdin.readline().split())

def play(mid, room, a_list, h_list, hero_atk):
    health = mid
    for i in range(n):
        if room[i] == 1:
            monster_atk = a_list[i]
            monster_health = h_list[i]

            attack_cnt = monster_health // hero_atk
            if attack_cnt * hero_atk < monster_health:
                attack_cnt += 1

            beat_cnt = attack_cnt - 1
            if beat_cnt * monster_atk >= health:
                return False
            health -= (monster_atk * beat_cnt)
        if room[i] == 2:
            hero_atk += a_list[i]
            if health + h_list[i] >= mid:
                health = mid
            else: health += h_list[i]
        if health <= 0:
            return False
    else: return health
    
room = []
a_list = []
h_list = []
start = 1
end = 123456 * 1000000 * 1000000
answer = end

for _ in range(n):
    t, a ,h = map(int, sys.stdin.readline().split())
    room.append(t)
    a_list.append(a)
    h_list.append(h)

while(start<=end):
    hero_atk = atk
    mid = (start+end)//2
    result = play(mid, room, a_list, h_list, hero_atk)
    if result > 0 and answer > mid:
        answer = mid
    if result :
        end = mid - 1
    else :
        start = mid + 1
print(answer)