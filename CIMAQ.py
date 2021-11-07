#Importer deux fichiers (excel et json) et comparer les deux fichiers 
import pandas as pd 

#Importer fichier json 
chemin = "/Users/lynaelhaffaf/Documents/CIMAQ/rawdata.json"
df = pd.read_json(chemin).to_excel("output.xlsx")
#readfile = pd.read_json(chemin)
df1 = pd.DataFrame(readfile)
print(df1)

#importer fichier excel 
participants = "/Users/lynaelhaffaf/Documents/CIMAQ/participantsprojet CogCtrl_.xlsx"
p = pd.read_excel(participants)
df3 = pd.DataFrame(p)
df3

#Comparer les deux fichiers 
comparevalues= df1.values == df3.values
print(comparevalues)

#Ajouter sur un fichier excel les valeurs différentes entre deux fichiers
import numpy as np 
rows,cols = np.where(comparevalues == False)
for item in zip(rows,cols):
    df1.iloc[item[0], item[1]] = '{} --> {}'.format(df1.iloc[item[0], item[1]],df3.iloc[item[0], item[1]])
df1.to_excel("/Users/lynaelhaffaf/Documents/CIMAQ/output1.xlsx")
