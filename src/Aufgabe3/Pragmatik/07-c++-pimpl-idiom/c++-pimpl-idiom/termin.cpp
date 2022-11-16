// termin.cpp
#include "termin.h"

struct termin::impl
{
    datum wann;
    std::string was;
    impl(const datum& d, const std::string& s) : wann(d), was(s) { }
};

termin::termin(const datum& d, const std::string& s)
: pimpl(new impl(d, s))
{ }

termin::~termin() = default;

void termin::verschieben(const datum &d)
{
    this->pimpl->wann = d;
}

datum termin::get_datum() const
{
    return this->pimpl->wann;
}

std::string termin::get_beschreibung() const
{
    return this->pimpl->was;
}

