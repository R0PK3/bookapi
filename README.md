# Sourcery Academy for Full-Stack | Bonus task 2024
Before trying to start the application, make sure that you have Installed **Java JDK 23**, **Postman**, **git**, **npm**, **maven** and set them as environment variables.
# How to launch the application?
1) Clone the repository `git clone https://github.com/R0PK3/bookapi.git` and change directory `cd bookapi`.
2) Build the Project with Maven `mvn clean install`.
3) Run the application by writing `mvn spring-boot:run` in the console.
4) Use `Ctrl + c` (on Windows) if you want to exit.
# Additional options
- Project uses a **H2 database** which is stored in a local file, located at project folder `bookapi/data`, if you want to view the database, use **H2 console**. Go to `http://localhost:8080/h2-console` enter JDBC URL as `jdbc:h2:file:./data/db-file`, set username and password as `sa` and `password` respectively.
- For endpoint testing (access) **Postman** was used. In order to get access to the endpoints, open **Postman**, take `BookAPI.postman_collection.json` file from repo and import it in your **Postman** workspace. There are 3 requests:
1. `GetAllBooks` — retrieves all the books and their information which is stored in the database.
2. `GetByFilters` — Uses parameters to filter out the books. Works the same as the first request if no parameters were selected.
3. `UpdateRate` — Updates rating of selected book. (By default, book with `1` id is getting modified)


