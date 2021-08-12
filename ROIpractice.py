#To check if the file exists 
import os
import json 
roi_data = "/Users/lynaelhaffaf/Documents/rois.json"
if os.path.exists(roi_data):
    print ('this file exists')
else: 
    print ('Not found')

#After adjusting the json file, 
#Read the ROI json file 
import json 
f = open('/Users/lynaelhaffaf/Documents/rois.json')
data = json.load(f)
for i in data['roi_details']: 
    print(i)
f.close()
