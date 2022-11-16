// termin.cpp
#include "termin.h"

termin::termin(const datum& d, const std::string& s)
: wann(d), was(s)
{ }

void termin::verschieben(const datum &d)
{
    this->wann = d;
}

datum termin::get_datum() const
{
    return this->wann;
}

std::string termin::get_beschreibung() const
{
    return this->was;
}

