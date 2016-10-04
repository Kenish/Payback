Zadanie zostało wykonane przy użyciu frameworku spring boot + spring data oraz angular 2 + typescript do front-endu. 
Hibernate jest providerem ORM a całość została zbudowana przy pomocy mavena.Serwerem aplikacyjnym jest spring bootowy embeded Tomacat a bazą danych lokalna h2. Aplikacja uruchamia się na porcie 9000.

Backend jest przygotowany na operacje crudowe jak
dodawanie i usuwanie użytkowników czy ich adresów.
przykład:
` curl -X POST localhost:9000/api/users/1/addresses -H "Content-Type: application/json" -d '{"country":"poland","city":"warsaw","postalCode":"02516","address":"złota59"}'`

aby uruchomić projekt nalezy pobrać zależności mavena oraz wykonać komendy `npm install` oraz `npm run tsc` w folderze static.
Aplikacja może uruchamiać się nieco powolnie z racjii nieskompresowanych bibliotek w node_modules.
