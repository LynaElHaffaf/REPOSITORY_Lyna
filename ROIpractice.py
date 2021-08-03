import os

#to check if the file exists 
roi_data = "rois.json"
if os.path.exists(roi_data):
    print ('this file exists')
