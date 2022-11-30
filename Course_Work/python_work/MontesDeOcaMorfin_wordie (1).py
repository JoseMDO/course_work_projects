# Jose Montes De Oca Morfin
# Wordie Homework

import random

def print_banner_block(width,message):
    print("*" * width)
    print(message.center(width))
    print("*" * width)
    print("")

def print_welcome():
    print_banner_block(80,"WORDIE")
    print("Welcome to WORDIE, the game everyone is playing. Your job is to guess")
    print("a five letter word. You start with a completely blank set of five letter")
    print("tiles. As you guess a letter that is in the word, it will appear, either")
    print("out of place, in which case it will be marked with a ? symbo, or in its")
    print("proper place, where it will be marked with a * symbol. The fewer tries")
    print("it takes you to get all the letters in the right place, the faster you")
    print("will guess the entire word. Only guesses that are actually words in the")
    print("word list will be accepted. Good luck!")

def print_game_board(guess,word,list_of_guesses):
    string_of_pos = ""
    guess_spaced = ""
    print("Here is the game board so far:")
    for guess in list_of_guesses:
        for i,ch in enumerate(guess):
            if ch in word:
                if guess[i] == word[i]:
                    string_of_pos = string_of_pos + "*" + "\t\t" 
                else:
                    string_of_pos = string_of_pos + "?" + "\t\t" 
            else:
                string_of_pos = string_of_pos + "x" + "\t\t"
                 
        for ch in guess:
            guess_spaced = guess_spaced + ch + "\t\t"
           
        print(string_of_pos)
        print(guess_spaced)
        print("")
        guess_spaced = ""
        string_of_pos = ""
        
    
    



    

print_welcome()
print("")
words = open("words.txt","r") # Opens word file 
word_list = []         # Creates an empty list so start the list of words 
line = words.readline()

for line in words:     
    line = line.strip()
    word_list.append(line)    # adds every line of words into the list of words 


do_again = "y"


while do_again == "y":
    word = random.choice(word_list)  # generates random word 
    number_of_guesses = 0
    list_of_guesses = []
    guess = ""
    while guess != word and number_of_guesses < 6:   # starts the while loop for all the attempts 
        guess = input("Enter your guess: ")
        if guess not in word_list:
            print("That word is not in the list")
        else:
            number_of_guesses = number_of_guesses + 1
            list_of_guesses.append(guess)
            print_game_board(guess,word,list_of_guesses)  # prints the game board after every try 

    if guess == word:
        print("Congratulations you guessed the word!")
    else:
        print("I'm sorry. You did not guess the word, which was %s." % word)
        print("")

    options = ["y" , "n"]  # Gives options for if you want to play again or not
    success = False 
    while success == False:
        do_again = input("Do you want to play again?")
        if do_again in options:
            success = True
        else:
            print("You must enter either 'y' or 'n'.")
            
                
        
            
print("")
print("Thank you for playing Wordie!")

