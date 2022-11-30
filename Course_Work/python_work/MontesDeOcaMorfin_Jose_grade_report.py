# Jose Montes De Oca Morfin 
# HW 8 Official Transcripts 

def print_banner_block(width,message):
    print("*" * width)
    print(message.center(width))
    print("*" * width)

def board_printout(gpa,semester,sem_hours,sem_quality_points):
    if gpa >= 3.5:
        print("%-26s%-7d%-10.2f%10.2f%20s" % (semester.upper(),sem_hours,sem_quality_points,gpa,"DEAN'S LIST"))
    else:   
        print("%-26s%-7d%-10.2f%10.2f" % (semester.upper(),sem_hours,sem_quality_points,gpa))
    



    
print_banner_block(80,"Grade Report Tool")
print("")
success = False
while success == False:
    try:
        fname = input("Enter name of grade report file: ")
        fvar = open(fname,"r")
        print("Here is your grade summary: ")
        print("")
        print("%s%20s%10s%15s%20s" % ("Semester","Hours","Points","GPA","Standing"))
        print("-" * 80)
        success = True
    except:
        print("That file does not exist. Please try a different file.")


total_quality_points = 0  # initialize totals
total_hours = 0 
total_gpa = 0
total_semesters = 0
gpa_list = []
semester_list = []


grades_earned = {"A":[],"A-":[],"B+":[],"B":[],"B-":[],"C+":[],"C":[],"C-":[],"D+":[],"D":[],"D-":[],"F":[]} # Dictionary for all grades and classes with each grade  


for line in fvar:
    line = line.strip()
    if line == "":  # restarts the semester 
        gpa = sem_quality_points / sem_hours
        gpa_list.append(gpa)
        lowest_gpa = gpa_list[0]
        highest_gpa = gpa_list[0]
        for gpa in gpa_list:   # finds highest and lowest gpa
            if gpa > highest_gpa:
                highest_gpa = gpa
            elif gpa < lowest_gpa:
                lowest_gpa = gpa
        total_gpa = total_gpa + gpa
        total_quality_points = total_quality_points + sem_quality_points
        total_hours = total_hours + sem_hours 
        board_printout(gpa,semester,sem_hours,sem_quality_points)
    else:
        parts = line.split("\t")
        if parts[0] == "Semester":   # beggining of new semester 
            sem_quality_points = 0
            sem_hours = 0
            total_semesters = total_semesters + 1
            semester = parts[1]
            semester_list.append(semester.upper())
        else:
            course_num = parts[0]
            course_name = parts[1]
            hours = int(parts[2])
            grade = parts[3]
            if grade == "A":            # calculate class quality points and adds it to dictionary 
                class_quality_points = 4.0 * hours
                grades_earned["A"].append(course_num)
            elif grade == "A-":
                class_quality_points = 3.7 * hours
                grades_earned["A-"].append(course_num)
            elif grade == "B+":
                class_quality_points = 3.3 * hours
                grades_earned["B+"].append(course_num)
            elif grade == "B":
                class_quality_points = 3.0 * hours
                grades_earned["B"].append(course_num)
            elif grade == "B-":
                class_quality_points = 2.7 * hours
                grades_earned["B-"].append(course_num)
            elif grade == "C+":
                class_quality_points = 2.3 * hours
                grades_earned["C+"].append(course_num)
            elif grade == "C":
                class_quality_points = 2.0 * hours
                grades_earned["C"].append(course_num)
            elif grade == "C-":
                class_quality_points = 1.7 * hours
                grades_earned["C-"].append(course_num)
            elif grade == "D+":
                class_quality_points = 1.3 * hours
                grades_earned["D+"].append(course_num)
            elif grade == "D":
                class_quality_points = 1.0 * hours
                grades_earned["D"].append(course_num)
            elif grade == "D-":
                class_quality_points = 0.7 * hours
                grades_earned["D-"].append(course_num)
            elif grade == "F":
                class_quailty_points = 0.0 * hours
                grades_earned["F"].append(course_num)
            
            sem_quality_points = sem_quality_points + class_quality_points
            sem_hours = sem_hours + hours
            
    
fvar.close()


gpa = sem_quality_points / sem_hours
gpa_list.append(gpa)
lowest_gpa = gpa_list[0]
highest_gpa = gpa_list[0]



board_printout(gpa,semester,sem_hours,sem_quality_points)

total_quality_points = total_quality_points + sem_quality_points
total_hours = total_hours + sem_hours
total_gpa = total_gpa + gpa
avg_gpa = total_gpa / total_semesters

print("-" * 80)
if avg_gpa >= 3.9:   # Figures out where they fall on grading system and all cumulative scores 
    print("%-26s%-7d%-10.2f%10.2f%20s" % ("Cumulative",total_hours,total_quality_points,avg_gpa,"HIGHEST HONORS"))
elif avg_gpa >=3.75:
    print("%-26s%-7d%-10.2f%10.2f%20s" % ("Cumulative",total_hours,total_quality_points,avg_gpa,"HIGH HONORS"))
elif avg_gpa >=3.5:
    print("%-26s%-7d%-10.2f%10.2f%20s" % ("Cumulative",total_hours,total_quality_points,avg_gpa,"HONORS"))
else:
    print("%-26s%-7d%-10.2f%10.2f" % ("Cumulative",total_hours,total_quality_points,avg_gpa,))


for gpa in gpa_list:
    if gpa > highest_gpa:
        highest_gpa = gpa
    elif gpa < lowest_gpa:
        lowest_gpa = gpa

print("")
print("Your best semester was %s" % semester_list[gpa_list.index(highest_gpa)])
print("Your worst semester was %s" % semester_list[gpa_list.index(lowest_gpa)])

print("")
print("Here is the grade breakdown:")



for grade in grades_earned:     # prints grade breakdown 
    if len(grades_earned[grade]) > 0:
        print(grade)
        str_of_classes = grades_earned[grade]
        for i in str_of_classes:
            print("%18s" % i)
        
