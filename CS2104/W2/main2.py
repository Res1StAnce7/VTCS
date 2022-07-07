def leapYear(year):
    if (year % 4 == 0):
        if (year % 100 == 0):
            if (year % 400 != 0):
                print("It is not a leap year.")
            else:
                print("It is a leap year.")
        else:        
            print("It is a leap year.")
    else:
        print("It is not a leap year.")

leapYear(1900)
leapYear(2003)
leapYear(2004)