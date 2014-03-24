MCZ 
3/5/2014

this folder contains the downloads from the "Drugs@FDA Data Files" site: 

http://www.fda.gov/Drugs/InformationOnDrugs/ucm079750.htm

We need to do a bit of pre-processing to get the data in a more friendly format:

 	 remove the header: 
		tail -n+2 Product.txt 
	 remove generics (both drug name" and "active ingredients" are the same) and print out only the fields we need (note we change the column order): 
		awk -F\\t '{if ($8 != $9) print $8"\t"$9"\t"$4"\t"$3;}'
	 remove double quotes:
		  sed "s/\"//g"
 	 remove text: "**Federal Register determination that product was not discontinued or withdrawn for safety or efficacy reasons**"
		sed "s/\*\*.*\*\*"//g"
	 rearange:
		sort | uniq
 
	So the finally one-liner is: 

	tail -n+2 Product.txt | awk -F\\t '{if ($8 != $9) print $8"\t"$9"\t"$4"\t"$3;}' | sed "s/\"//g" | sed "s/\*\*.*\*\*"//g"| sort | uniq > new_file_name.txt
