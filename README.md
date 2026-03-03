# Library Example App

A very simple Spring Boot 2 - Library example app: https://www.youtube.com/watch?v=-f-7l8X716k

Az alábbi feladatokat kell megvalósítani:
- A könyvek entitást ki kell kiegészíteni a szerzők entitással, ami több a többhöz
kapcsolatban áll a könyvekkel. A szerzőknek legyenek olyan attribútumai, mint id, name
(String), birth_date (LocalDate), origin_country (enum). A két entitás között a kapocs az
id.
- Egy külön controllert kell létrehozni a szerzőknek, ahol az alap CRUD műveleteken kívül
meg kell valósítani egy POST query végpontot, ahol a name, birth_date, origin_country
mellett még a könyvek darabszámára is lehessen szűrni, aminek a megvalósítása
CriteriaBuilder segítségével történjen. A válasznak egy saját DTO-nak kell lennie, ami a
szerzők és könyveik adatai mellett ezt a számított értéket is tartalmazza.
- Az adatstruktúra létrehozása és teszt adatokkal való feltöltése Liquibase-zel legyen
megvalósítva.
- A futtatáshoz szükséges adatbázis kiválasztása szabadon történhet.
- A Thymeleaf-en nem kell átvezetni a változásokat, viszont kérnénk egy Postman test
collection-t helyette.
- A végpontokon legyen Spring security beállítva role ellenőrzéssel. A user-eket elég
konfigban vagy a választott DB-ben tárolni.
