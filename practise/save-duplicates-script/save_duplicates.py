#! /usr/bin/python3
import glob
import sys
import os

# sys.argv[] gives users argument input eg. "command arg1 arg2"
# os.path.abspath() gives absolute path
FOLDER1 = os.path.abspath(sys.argv[1])
FOLDER2 = os.path.abspath(sys.argv[2])

def listing():
    print(FOLDER1, FOLDER2)
    os.chdir(FOLDER1)           # Change working directory
    files = glob.glob('*')
    print(files)
    for file in files:
        print(file)
    #abspath = os.path.abspath(FOLDER1)
    #print(abspath)
    

#def file_removal(rm_files):

listing()
