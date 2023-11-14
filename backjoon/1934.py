def gcd(num1, num2):
    a = max(num1, num2)
    b = min(num1, num2)
    r = a % b
    if(r == 0):
        return b
    else: 
        return gcd(b,r)
    
line = int(input())
    
for i in range (line):
    a, b = map(int, input().split())
    print(int(a*b/gcd(a,b)))