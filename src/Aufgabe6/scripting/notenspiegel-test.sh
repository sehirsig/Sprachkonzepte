#!/bin/sh
./notenspiegel << eingabeende \
| diff -w - notenspiegel-out.txt \
|| { echo 'Test failed!' ; exit 1 ; } ; echo 'Test succeeded!'
Mathematik_2 23
Mathematik_2 B
Stochastik 17
Programmiertechnik_2 27
Systemprogrammierung 30
Systemprogrammierung B
Rechnerarchitekturen 40
Rechnerarchitekturen N
Rechnerarchitekturen 11
Rechnerarchitekturen X
NN 50
NN N
eingabeende
