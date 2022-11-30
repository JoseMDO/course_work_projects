# Jose Montes De Oca Morfin
# HW 11 Last Assignment (Collections)

import PySimpleGUI as sg



class Cars:  # Sets up the class with all required functions 
    def __init__(self,make,model,year,color):
        self.make = make
        self.model = model
        self.year = year
        self.color = color
    def calc_age(self):
        return 2022 - int(self.year)
    def __str__(self):
        return "%s %s %d (%d years old) %s" % (self.make,self.model,int(self.year),Cars.calc_age(self),self.color)
    def organized_description(self):
        return "Make: %s \nModel: %s \nYear: %d (%d years old) \nColor: %s \n\n" % (self.make,self.model,int(self.year),Cars.calc_age(self),self.color)
    def __lt__(self,other):
        return self.year < other.year
    def __le__(self,other):
        return self.year <= other.year
    def __gt__(self,other):
        return self.year > other.year
    def __ge__(self,other):
        return self.year >= other.year
    def __eq__(self,other):
        return self.year == other.year
    def str_of_list(self,list_cars):      # Creates a str with a proper organmized description for the summary box 
        str_of_cars = ""
        for car in list_cars:
            str_of_cars = str_of_cars + car.organized_description() 
        return str_of_cars

    
    
        
layout = [[sg.Text("Cars Collection Tool")],
          [sg.Text("Make"),sg.Input(size = (10,5),key = "make")],
          [sg.Text("Model"),sg.Input(size = (10,5),key = "model")],
          [sg.Text("Year"),sg.Input(size = (6,5), key = "year"),sg.Text("Color"),sg.Input(size = (6,5), key = "color")],
          [sg.Button("OK"), sg.Button("Close"),sg.Button("Save to File")],
          [sg.Multiline(size=(30,15),key = "summary")]]
          
            
win = sg.Window("Cars Collection Tool", layout = layout)

text = ""

list_of_cars = []
str_of_cars = ""


while True:
    event,data = win.read()
    if event == "OK":
        success = False
        try:  # test to make sure year is an int 
            num = int(data["year"])
            success = True
        except:
            sg.popup("You must type an integer for the year")
        if success == True:
            car = Cars(data["make"],data["model"],data["year"],data["color"]) # Creates the Car object
            list_of_cars.append(car)
            list_of_cars.sort()
            str_of_cars = car.str_of_list(list_of_cars)  # calls the function for the Car class to make a string for the summary
            win["summary"].update(str_of_cars)
            win["make"].update("")
            win["model"].update("")
            win["year"].update("")
            win["color"].update("")
            
    elif event == "Save to File":
        fname = sg.popup_get_text("Enter name of file: ")
        try:
            fvar = open(fname, "w")
            for car in list_of_cars:  # Adds each car to the string to add to the file 
                fvar.write(str(car) + "\n")
            fvar.close()
            sg.popup("Cars Collection was saved to: %s " % fname)
        except:
            sg.popup("Could not save the text.")
        
    elif event == sg.WIN_CLOSED or "Close":
        break



win.close()



