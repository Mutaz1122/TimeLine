# TimeLine
1.1. Problem Description
xyzSoft is a software house providing services and products for several clients. Project managers at xyzSoft uses an
enterprise application (called E_Manage) to manage these ongoing projects during the various stages. However,
E_Manage does not provide proper reporting capabilities. Instead, it allows exporting data in Excel format (Multiple
Workbooks). The Quality Management Department at xyzSoft usually spend long time trying to process these exported
files to come up with insights about the running projects. Ahmad (from Quality Management Department)
contacted you to help him in this long and time-consuming process. He provided few samples containing projects information. For
each project, there is a list of stages which are stored in a different workbook 

1.2. What is required?
You are required to go through the sample files and understand the structure and data related to projects and their
stages. Currently there are 3 files that you need to consider:
The first file (Projects.xls) contains basic data about each project plus a list of dates related to the project.
The other two files are related to Stages for each project. Unfortunately, E_Manage system did not have these files in a
combined format so you need to merge them together (I mean you write your code so that it accepts two files and
merge them using code).
The Project info can be linked to stages info by NodeID (from Projects file) and ObjectValue (from stages files)
Develop Java application that parses the data in these files. After parsing the Excel files, you have to store the data of
projects and their stages in objects. 

Task 2: Develop the application
For this homework, we will just read the data from these Excel files and present them in proper GUI application. Simply I
need to list all projects in a list box on the left of the screen (as shown below) and draw a timeline representing the
stages of the selected project and the duration from the first event to the last event. The client (Ahmed) didn’t specify
the GUI that he needs, so, feel free to improvise in terms of your design of the GUI.

