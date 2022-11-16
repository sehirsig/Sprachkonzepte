// datum.h
#ifndef DATUM_H
#define DATUM_H

#include <iostream> // istream, ostream
#include <memory>   // unique_ptr

class datum final
{
private:
    // pointer to implementation idiom
    struct impl;
    std::unique_ptr<impl> pimpl;
public:
    static datum heute();
    datum();
    datum(int t, int m, int j);
    ~datum();
    datum(const datum&);
    datum& operator=(const datum&);
    datum(datum&&);
    datum& operator=(datum&&);
    
    friend bool operator==(const datum&, const datum&);
    friend std::ostream& operator<<(std::ostream&, const datum&);
};

std::istream& operator>>(std::istream&, datum&);

#endif

