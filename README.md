- CommandLine Way of running the code
- mvn clean
- mvn clean install
- mvn spring-boot:run


Code works with Visual Studio for Debugging.
Java 21 or 17 works

1. PosgresSQL 16 has been used as relational database.

2. Database Schema

```sql
Long id

String product

Long version

Long year

Long price

```
3. products table is created in ecommerce database.

4.
```shell
psql -d ecommerce
```

```shell
SELECT tablename FROM pg_tables WHERE schemaname = 'public';
```
