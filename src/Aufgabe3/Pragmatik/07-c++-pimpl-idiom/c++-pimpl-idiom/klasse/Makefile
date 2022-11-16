#
# Makefile
#
# Autor: H.Drachenfels
# erstellt am: 15.4.2021
#

CXX = g++
CPPFLAGS =
CXXFLAGS = -g -Wall -Wextra -std=c++11

TARGETS = datumtest termintest

OBJECTS = datum.o termin.o

all: $(TARGETS)

clean:
	rm -f $(TARGETS) $(TARGETS:=.o) $(OBJECTS)

datumtest: datumtest.o datum.o
	$(CXX) $(CXXFLAGS) $^ -o $@

termintest: termintest.o $(OBJECTS)
	$(CXX) $(CXXFLAGS) $^ -o $@

datumtest.o: datumtest.cpp datum.h
datum.o: datum.cpp datum.h

termintest.o: termintest.cpp termin.h datum.h
termin.o: termin.cpp termin.h datum.h

