import os

#to check if the file exists 
roi_data = "rois.json"
if os.path.exists(roi_data):
    print ('this file exists')

#To read the ROI json file  
import pandas as pd
import json
file_path = "/Users/lynaelhaffaf/Documents/rois.json"
df = pd.read_json(file_path)
df
