import os

#to check if the file exists 
import os
import json 
roi_data = "/Users/lynaelhaffaf/Documents/rois.json"
if os.path.exists(roi_data):
    print ('this file exists')
else: 
    print ('Not found')

#To read the ROI json file  
import pandas as pd
import json
file_path = "/Users/lynaelhaffaf/Documents/rois.json"
df = pd.read_json(file_path)
df
