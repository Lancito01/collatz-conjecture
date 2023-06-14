from time import sleep

def conjecture(number):
    saved_input = number
    largest_number_achieved = number
    number_of_steps = 0
    print(number)

    while number != 1:
        if number % 2 == 0: #? if the number is even
            number = number / 2
        else: #? if the number is odd
            number = number * 3 + 1

        number_of_steps += 1

        if number > largest_number_achieved:
            largest_number_achieved = number

        print(int(number))
        # sleep(0.035) #! this line will slow down the program

    print("> It took", number_of_steps, "steps to reach 1 from", str(int(saved_input)) + ".")
    print("> The largest number achieved was", str(int(largest_number_achieved)) + ".")

def choose_number(message = "Enter a number:\n> "):
    current_number = 0
    while current_number <= 0:
        try:
            current_number = int(input(message))
            if current_number <= 0:
                print("Please enter a positive integer.")
        except ValueError:
            print("Please enter a valid integer.")
    return current_number

choice = 0
while True:
    try:
        choice = int(input("Enter a number:\n\t> 1 to run the program just once.\n\t> 2 to run the program infinetely, starting from any number.\n> "))
        if choice == 1 or choice == 2:
            break
        else:
            print("Please enter a number that represents an option.")
    except ValueError:
        print("Please enter a valid integer.")

number = 0
if choice == 1:
    number = choose_number()
    conjecture(number)
elif choice == 2:
    number = choose_number("Enter the number to start from:\n> ")
    while True:
        print("\n> Running program with number", str(int(number)) + "...")
        conjecture(number)
        number += 1
        # sleep(0.5) #! this line will slow down the program
