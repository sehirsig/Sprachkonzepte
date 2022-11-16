// datum.cpp
#include "datum.h"
#include <stdexcept>
#include <ctime>
#include <cstdio>
#include <iomanip>
#include <ios>
#include <string>

datum datum::heute()
{
    std::time_t t = std::time(0);
    std::tm *p = std::localtime(&t);
    return {p->tm_mday, p->tm_mon + 1, p->tm_year + 1900};
}

datum::datum(int t, int m, int j)
: tag(t), monat(m), jahr(j)
{
    // Konsistenzpruefung (stark vereinfacht)
    if (t < 1 || t > 31 || m < 1 || m > 12)
    {
        throw std::invalid_argument("ungueltiges Datum");
    }
}

bool operator==(const datum& lhs, const datum& rhs)
{
    return &lhs == &rhs || (lhs.tag == rhs.tag
                            && lhs.monat == rhs.monat
                            && lhs.jahr == rhs.jahr);
}

std::ostream& operator<<(std::ostream& os, const datum& d)
{
    return os << d.jahr
              << '-' << std::setw(2) << std::setfill('0') << d.monat
              << '-' << std::setw(2) << std::setfill('0') << d.tag;
}

std::istream& operator>>(std::istream& is, datum& d)
{
    std::string eingabe;
    if (!(is >> eingabe))
    {
        return is;
    }

    int j, m, t;
    if (std::sscanf(eingabe.c_str(), "%d-%2d-%2d", &j, &m, &t) != 3)
    {
        is.setstate(std::ios::failbit);
        return is;
    }

    try
    {
        d = {t, m, j}; // datum(t, m, j);
    }
    catch (std::invalid_argument&)
    {
        is.setstate(std::ios::failbit);
    }

    return is;
}

