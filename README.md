# Library Example App

A very simple Spring Boot 2 - Library example app: https://www.youtube.com/watch?v=-f-7l8X716k

**Az alábbi feladatokat kell megvalósítani:**

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

**Megvalósítás:**

- A választott adatbázis a **H2** lett, az egyszerűség kedvéért.
- Az **AuthorController** REST controller létre lett hozva a következő végpontokkal:
  - GET /author -- minden szerző lekérdezése
  - GET /author/{id} -- egy szerző lekérdezése id alapján
  - POST /author -- új szerző létrehozása
  - PUT /author/{id} -- egy szerző adatainak frissítése id alapján
  - DELETE /author/{id} -- egy szerző törlése id alapján
  - POST /author/search -- szerzők keresése név, születési idő, származási ország és a könyvek darabszáma alapján
- A végpontokhoz **Spring Security role ellenőrzés** lett beállítva, két szerepkörrel: USER és ADMIN.
  - USER vagy ADMIN szerepkör: A két GET végpont és a POST /author/search végpontnál
  - csak ADMIN szerepkör: POST, PUT és DELETE végpontok
- Két **liqubase script** lett létrehozva:
  - src/main/resources/db/changelog/001-create-tables.sql -- a könyvek és szerzők tábláinak létrehozása
  - src/main/resources/db/changelog/002-load-sample-data.sql -- teszt adatok betöltése a könyvek és szerzők táblákba
- A teszteléshez egy **Postman test collection** lett létrehozva, amely tartalmazza a fent említett végpontok tesztjeit, beleértve a negatív teszteket is (nem létező id és elégtelen auth esetén).
  - src/test/resources/postman/library.postman_collection.json 


**Ismert hibák:**

- A **H2 adatbázis kezelői felülete** (/h2-console) nem indul el, annak ellenére, hogy a beállítások látszólag megfelelőek.
