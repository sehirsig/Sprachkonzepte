// datum.h
#ifndef DATUM_H
#define DATUM_H

#include <iostream> // istream, ostream

class datum final
{
private:
    int tag;
    int monat;
    int jahr;
public:
    static datum heute();
    datum() = default;
    datum(int t, int m, int j);

    friend bool operator==(const datum&, const datum&);
    friend std::ostream& operator<<(std::ostream&, const datum&);
};

std::istream& operator>>(std::istream&, datum&);

#endif

