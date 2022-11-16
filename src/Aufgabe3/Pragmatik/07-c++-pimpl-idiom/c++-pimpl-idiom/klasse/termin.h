// termin.h
#ifndef TERMIN_H
#define TERMIN_H

#include "datum.h"
#include <string>

class termin final
{
private:
    datum wann;
    std::string was;
public:
    termin(const datum&, const std::string&);

    // Entity-Klasse: keine Copy-Move-Semantik
    termin(const termin&) = delete;
    termin& operator=(const termin&) = delete;
    termin(termin&&) = delete;
    termin& operator=(termin&&) = delete;

    void verschieben(const datum&);
    datum get_datum() const;
    std::string get_beschreibung() const;
};

#endif

