# Jose Montes De Oca Morfin
# Homework 5
# File Analyzer

print("*" * 66)
print("%43s" % "TEXT ANALYZER V1.0")
print("*" * 66)
print("")

print('''
This program first asks you to enter the name of a text file. It will
load the file into memory. It will then give you a set of options to
choose from that will enable you to learn more about the contents of
the file.
''')

fname = input("Enter name of file: ")
success = False 

while success == False:  # try to succesfully load a file 
    try:
        fvar = open(fname,"r")
        success = True
    except Exception as e:
        print("The following error occured: ")
        print("       ", e)
        print("")
        fname = input("Enter the name of a file: ")

text = ""
for line in fvar:
    text = text + line.strip() + " "
fvar.close()

print("")

print("The file has been loaded into memory.")
print("")

choice = 0

        
while choice != 6:   # Menu of choices 
    print("Here are your choices: ")
    print("1. Count the number of characters. ")
    print("2. Count the number of vowels. ")
    print("3. Count the number of words. ")
    print("4. Extract a portion of the file. ")
    print("5. Print the characters of the file backwards. ")
    print("6. Quit ")
    
    success = False
    while success == False:  # try for the integer choice 
        try:
            choice = int(input("Please type the number of your choice: "))
            success = True
        except Exception as e:
            print("You have to enter an integer.")

    if choice == 1:  # Counting characters 
        count = 0
        for ch in text:
            count = count + 1
        print("there are %d characters in the file." % count)
        print("")

    if choice == 2:
        vowel_count = 0 # counting vowels 
        for ch in text.lower():
            if ch == "a" or ch == "e" or ch == "i" or ch == "o" or ch == "u":
                vowel_count = vowel_count + 1
        print("There are %d vowels in the file." % vowel_count)
        print("")

    if choice == 3: # if space is detected a word is accounted for 
        word_count = 0
        for ch in text:
            if ch == " ":
                word_count = word_count + 1
        print("There are %d words in the file." % word_count)
        print("")


    if choice == 4:   # reading string between two indexes 
        first_index = int(input("Enter index of first character to include: "))
        last_index = int(input("Enter index of last character to include: "))
        print("Here is the extract: ")
        result = ""
        for i in range(first_index,last_index):
            result = result + text[i]
        print("%30s" % result)
        
            
    if choice == 5:
        result = ""
        count = 0 
        for i in range(len(text)-1,0,-1): # reading string backwards 
            count = count + 1
            result = result + text[i]
            if count == 70:
                print(result)
                count = 0
                result = ""
        print(result + text[0])

        
print("")
print("*" * 66)
print("%50s" % "Thank you for using this program.")
print("*" * 66)
        
        
            

    
        
        
                        
                
        
            
        
            
        




        
        
                
        
            
    
    




    
