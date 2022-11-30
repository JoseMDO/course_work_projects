#################################################################################
# Jose Montes De Oca Morfin
# CPSC 21000 Section 001
# Program to Calculate Your Monthly Mortgage Payment 
################################################################################



print("*****************************************************************************")
print("%57s" % "HOME MORTGAGE PAYMENT CALCULATOR V1.0")
print("*****************************************************************************")
print("\n")
print('''
In this program, we will calculate your monthly mortgage payment.
You will enter the cost of the home you are buying and how much
of a down payment you are making. You will then enter the annual
interest rate as well as the lenght of the loan in years. The
program will take this information and compute your monthly
mortgage payment. If your down payment is less than 20% of the
cost of the home, you will have to pay a mortgage insurance fee
of $100 per month.
''')
print("\n")
property_value = int(input("Enter the cost of the home: $"))
down_payment = int(input("Enter the down payment you are making: $"))
interest_rate = float(input("Enter the annual interest rate %: "))
loan_duration = int(input("Enter the lenght of the loan in years: "))

loan_amount = property_value - down_payment
number_months = loan_duration * 12
monthly_interest_rate = (interest_rate * .01) / 12
if down_payment < .20 * property_value:
    pmi = 100.00
else:
    pmi = 0.00
if down_payment >= .20 * property_value:
    monthly_payment = (monthly_interest_rate * loan_amount) / (1 - (1 + monthly_interest_rate) ** -number_months)
else:
    monthly_payment = (monthly_interest_rate * loan_amount) / (1 - (1 + monthly_interest_rate) ** -number_months) + pmi
monthly_mortgage = monthly_payment - pmi
print("\n")
print("Here is a summary of your loan: ")
print("Loan amount             $%10.2f" % loan_amount)
print("Annual interest rate    %10.2f%%" % interest_rate)
print("Number of years          %10d" % loan_duration)
print("Monthly mortgage        $%10.6s " % monthly_mortgage)
print("Mortgage insurance      $%10.2f" % pmi)
print("Total per month         $%10.2f" % monthly_payment)
print("\n")
print("****************************************************************************")
print("%55s" % "Thank you for using this program.")
print("****************************************************************************")


