# Jose Montes De Oca Morfin
# HW 9 Graphing

import PySimpleGUI as sg
import matplotlib.pyplot as plt
import math

layout = [[sg.Text("This plotting tool shows you the difference between a linear,")],
          [sg.Text("quadratic, cubic, logarithmic, and linearithmic curve.")],
          [sg.Text("What do you want to plot? Check the boxes.")],
          [sg.Checkbox("Linear",key="linear"),sg.Checkbox("Quadratic",key="quadratic"),sg.Checkbox("Cubic",key="cubic"),sg.Checkbox("Logarithmic",key="logarithmic"),sg.Checkbox("Linearithmic",key="linearithmic")],
          [sg.Text("Enter min x: "),sg.Input(size = (10,5),key = "min_x"),sg.Text("Enter max x: "), sg.Input(size = (10,5),key="max_x")],
          [sg.Button("Plot"),sg.Button("Close")]]

win = sg.Window("Function Plotter", layout = layout)

while True:
    event, values = win.read()
    
    list_of_keys = ["linear","quadratic","cubic","logarithmic","linearithmic"]
    xs = []
    ys_linear = []
    ys_quadratic = []
    ys_cubic = []
    ys_log = []
    ys_linearithmic = []

    
    if event == "Plot": # if the user is ready to plot
        success = False
        try:
            min_x = int(values["min_x"])
            max_x = int(values["max_x"])
            success = True
        except:
            sg.Popup("You must specify integers for Min X and Max X")
        if success == True:  
            if values["linear"] != True and values["quadratic"] != True and values["cubic"] != True and values["logarithmic"] != True and values["linearithmic"] != True:
                sg.popup("You must select at least one checkbox.")  # make sure at least one box is selected 
            elif min_x > max_x:
                sg.popup("Min X must be less than Max X.") # make sure min x is less than max x 
            elif min_x < 1:
                sg.popup("Min X must be greater than or equal to 1")  # make sure min x is less than 1 
            else:
                for i in range(min_x, max_x +1):  # adds the correct numbers to the graph based on users choice of numbers 
                    xs.append(i)
                    ys_linear.append(i)
                    ys_quadratic.append(i**2)
                    ys_cubic.append(i**3)
                    ys_log.append(math.log(i,2))
                    ys_linearithmic.append(i * math.log(i,2))

                            
                dict_of_keys = {"linear":ys_linear,"quadratic":ys_quadratic,"cubic":ys_cubic,"logarithmic":ys_log,"linearithmic":ys_linearithmic}
                legend_items = []
                for key in list_of_keys:  
                    if values[key] == True:  # Creates the graph based on what is selected and creates the legend based on what is selected 
                        plt.plot(xs,dict_of_keys[key])
                        plt.xlabel("X")
                        plt.ylabel("Y")
                        plt.title("Alogrithm Complexity Functions")
                        legend_items.append(key)
                        plt.grid(True)
                plt.legend(legend_items)
                plt.show()
                plt.figure()
                        
                        
                
                                
    elif event == "Close" or win.close:
        win.close()
        break   
    
        
        
    
