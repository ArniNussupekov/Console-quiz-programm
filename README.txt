This is a console program, the purpose of which is to conduct testing. The text is taken from a txt file. When starting the program, you need to pass the file name as args[0].
The program reads the file and if it is an open question, the answer is checked for correctness. If this is a test, then the selected option is checked.
Rules for filling in a txt file:
1) Regardless of the type of question, 1 line is the question itself.
2) If this is an open question, then write the answer to the next line.
3) If this is a test, then the following lines are answer options. *the correct answer in the txt file should be the first.