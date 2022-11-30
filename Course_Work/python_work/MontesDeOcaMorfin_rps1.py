# Jose Montes De Oca Morfin
# Rock Paper Scissors Assignment


import random

print("*" * 66)
print("%45s" % "Rock Paper Scissors")
print("*" * 66)

print("")

print('''
In this classic game, you will play a number of
seven-game series of rock-paper-scissors against
the computer. I will show you who won each series,
and I will show you how many series you won and
lost at the end. 
''')
print("")


number_of_rounds = int(input("How many series do you want to play? "))
print("")

player_score = 0
computer_score = 0
player_series_score = 0
comp_series_score = 0
round_number = number_of_rounds - number_of_rounds + 1



print("Round %d" % round_number)
for i in range(number_of_rounds):#Loops for the amount of rounds player wants
    
    while player_score < 4 and computer_score < 4: #Starts the rock paper scissors game best of 7 
        player_choice = input("Enter r for rock, p for paper, or s for scissors: ").lower()
        comp_choice = random.randint(1,3)
        if comp_choice == 1:
            comp_choice = "r"
        elif comp_choice == 2:
            comp_choice = "p"
        else:
            comp_choice = "s"
        if player_choice == "r" and comp_choice == "r":
            print("It was a draw. You and the computer had the same thing.")
        if player_choice == "r" and comp_choice == "p":
            print("The computer had paper. Computer wins.")
            computer_score = computer_score + 1
        if player_choice == "r" and comp_choice == "s":
            print("The computer had scissors. You win.")
            player_score = player_score + 1
        if player_choice == "p" and comp_choice == "p":
            print("It was a draw. You and the computer had the same thing.")
        if player_choice == "p" and comp_choice == "s":
            print("The computer had scissors. Computer wins.")
            computer_score = computer_score + 1
        if player_choice == "p" and comp_choice == "r":
            print("The computer had rock. You win.")
            player_score = player_score + 1
        if player_choice == "s" and comp_choice == "s":
            print("It was a draw. You and the computer had the same thing.")
        if player_choice == "s" and comp_choice == "r":
            print("The computer had rock. Computer wins.")
            computer_score = computer_score + 1
        if player_choice == "s" and comp_choice == "p":
            print("The computer had paper. You win.")
            player_score = player_score + 1
        if player_score == 4: #Tells you if you won or if the comouter won depending who got 4 first 
            print("Congratulations. You won the series %s to %s" % (player_score,computer_score))
            player_series_score = player_series_score + 1
        elif computer_score == 4:
            print("Sorry, you lost the series %s to %s" % (computer_score,player_score))
            comp_series_score = comp_series_score + 1
    if player_series_score + comp_series_score == number_of_rounds: #This prints after the amount of loops in the for loops is done.
        print("")
        print("You won %d series and lost %d series." % (player_series_score,comp_series_score))
        print("Thank you for playing!")   
    else:
        player_score = 0
        computer_score = 0
        round_number = round_number + 1
        print("")
        print("Round %d" % round_number)
            
            





    
