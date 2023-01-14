from urllib.request import urlopen, Request
import xml.etree.ElementTree as ET
import datetime


def chooseCurrency(countryCode):
    today = datetime.date.today()
    year = today.year
    month = today.month
    day = today.day
    urlString = f"http://www.zoll.de/SiteGlobals/Functions/Kurse/KursExport.xml?view=xmlexportkursesearchresultZOLLWeb&kursart=1&iso2code2={countryCode}&startdatum_tag2={day}&startdatum_monat2={month}&startdatum_jahr2={year}&enddatum_tag2={day}&enddatum_monat2={month}&enddatum_jahr2={year}&sort=asc&spalte=gueltigkeit"
    r = Request(urlString)

    with urlopen(r) as response:
        page = response.read()

    tree = ET.ElementTree(ET.fromstring(page.decode("utf-8")))
    return tree.findall('kurs')


def getValue(k):
    return float(k[0].findall("kurswert")[0].text.replace(",", "."))


def getCName(k):
    return k[0].findall("iso3")[0].text


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print("Available countries for currency conversion: AU, CN, JP, CH, GB, US")
    money = input("Please choose an amount of Euro to convert: ")
    ccode = input("Please choose a country whose currency shall be converted to: ")
    print("Calculating...")
    kurs = chooseCurrency(ccode)
    factor = getValue(kurs)
    cname = getCName(kurs)
    umgerechnet = float(money) / factor
    print(f"{money} Euro is worth {round(umgerechnet,5)} in {cname}")
