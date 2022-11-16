// termin.h
#ifndef TERMIN_H
#define TERMIN_H

#include "datum.h"
#include <string>
#include <memory>

class termin final
{
private:
    struct impl;
    std::unique_ptr<impl> pimpl;
public:
    termin(const datum&, const std::string&);
    ~termin();

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

