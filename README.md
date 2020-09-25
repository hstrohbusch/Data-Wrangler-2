# Data-Wrangler-2
CS400 Project 1

Name: Michael Kukovec
Email: kukovec@wisc.edu
Team: AD
TA: Sophie Stephenson
Lecturer: Gary Dahl

The Book.java class contains the object that will be stored in our hash table.

Book_data.csv contains moc book data to test importing.
    -Make sure it is in the same folder as your project folder
    -DataWrangler will let you know if it is in the wrong place

The DataWrangler takes information from a .csv file and creates objects with it.

    -Returns 'false' if the file cannot be opened
    -Requires BackEndHash.add(Book n) to compile (adds book object into data structure)
    -The 'String file_name' is the name of the .csv file
        .csv file may contain double quotes, but must use ',' as the delimiter
        May also be a .txt file, but must still be comma delimited
