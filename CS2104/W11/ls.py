#!/usr/bin/python
import sqlite3

conn = sqlite3.connect('cs_course_scheduling.db')
print ("Opened database successfully\n")

print ("This is part 1")
cursor = conn.execute("SELECT first_name, last_name, academic_year FROM students")
for row in cursor:
   print ("First Name    = ", row[0])
   print ("Last Name     = ", row[1])
   print ("Academic Year = ", row[2])
   print ("----------------------------------------\n")

print ("This is part 2")
cursor = conn.execute("SELECT first_name, last_name, academic_year FROM students ORDER BY last_name ASC")
for row in cursor:
   print ("First Name    = ", row[0])
   print ("Last Name     = ", row[1])
   print ("Academic Year = ", row[2])
   print ("----------------------------------------\n")

print ("This is part 3")
cursor = conn.execute("SELECT first_name, last_name, academic_year FROM students WHERE academic_year = 4")
for row in cursor:
   print ("First Name    = ", row[0])
   print ("Last Name     = ", row[1])
   print ("Academic Year = ", row[2])
   print ("----------------------------------------\n")
   
print ("This is part 4")
year = input("Input the academic year: \n")
cursor = conn.execute("SELECT first_name, last_name, academic_year FROM students WHERE academic_year = ?", (year,))
for row in cursor:
   print ("First Name    = ", row[0])
   print ("Last Name     = ", row[1])
   print ("Academic Year = ", row[2])
   print ("----------------------------------------")

print("Operation done successfully")
conn.close()