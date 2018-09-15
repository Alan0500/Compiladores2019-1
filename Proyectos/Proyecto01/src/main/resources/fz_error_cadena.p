i = 1
while i <= limite:
    valor = 1
    if (i%3 == 0 and i%5 == 0):
        print("fizzbuzz\\")
        valor = 0
    if i % 3 == 0 :
        print("fizz")
        valor = 0
    if i%5 == 0:
        print("buzz")
        valor = 0
    if(valor == 1):
        print(i)
    i = i + 1
