#!/usr/bin/python3
liste = [123, 456, 890]
liste[1] = 4.56
liste.insert(1, 'Hallo')
liste.append(liste.pop(0))
print(liste)
