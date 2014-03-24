'''
Created on Mar 10, 2014

@author: michaelz

This script takes in the "parsed" FDA product info (raw data
available at: http://www.fda.gov/Drugs/InformationOnDrugs/ucm079750.htm)
and generates SQL INSERT statements.

The current processing is done via the one-liner:
 
tail -n+2 Product.txt | awk -F\\t '{if ($8 != $9) print $8"\t"$9"\t"$4"\t"$3;}' | sed "s/\"//g" | sed "s/\*\*.*\*\*"//g"| sort | uniq > new_file_name.txt

'''

import sys, os

if __name__ == '__main__':

    #print(sys.argv[1])
    
    inFile = open(sys.argv[1], "r")
    
    currentBrand = "i do not exist"
    childCount = 0;
    for line in inFile:
        # split on tab
        line = line.strip()
        (brand, generic, dose, type) = line.split('\t')
        if (currentBrand != brand):
            currentBrand = brand
            childCount = 0; 
            print("INSERT INTO rx ('comercial_name', 'generic_name' ) VALUES (\"" + brand + "\",\"" + generic + "\");")
        
        #print("\t" + dose + ":" + type)
        childCount = childCount + 1
        print(" INSERT INTO  rx_dose  ('Rx_id', 'dose_seq', 'dose', 'form' )  SELECT MAX(id)," + str(childCount) + ",\"" + dose + "\",\"" + type + "\" FROM rx ;")
  