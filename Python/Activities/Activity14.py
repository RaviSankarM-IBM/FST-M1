def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))
 
nterms = int(input("Enter a number: "))
 
if nterms <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(nterms):
        print(fibonacci(i))
    #number starts with 1
    #for i in range(1,nterms+1):
     #   print(fibonacci(i))