### CommandLine Way of running the code
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
5. Insert into table. 
```sql
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (103, 'B', 2, 2023, 150);
```

6. SQL Setup

```sql
CREATE TABLE IF NOT EXISTS Products (
  ID SERIAL PRIMARY KEY,
  Product VARCHAR(100),
  Version integer,
  PYear integer,
  Price integer
);
```    

```sql
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (101, 'A', 2, 2024, 200);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (102, 'A', 1, 2024, 100);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (106, 'A', 1, 2025, 200);

INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (103, 'B', 2, 2023, 150);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (104, 'B', 1, 2020, 50);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (105, 'B', 3, 2023, 250);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (111, 'B', 3, 2023, 550);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (112, 'B', 4, 2023, 1050);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (113, 'B', 4, 2023, 121);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (114, 'B', 1, 2023, 50);
INSERT INTO Products(ID, Product, Version, PYear, Price) VALUES (115, 'B', 1, 2022, 50);
```

```sql
SELECT * FROM Products;
-- trivial query
```

Rest EndPoints:

<ol>
  <li>http://localhost:8080/api/products : returns all records of product value.</li>
  <li>http://localhost:8080/api/products/maxproductprice : gives latest version of maximum priced product.</li>
  <li>http://localhost:8080/api/products/yearmax : gives each years maximum price ID.</li>
  <li>http://localhost:8080/api/products : gives unique (product, price) entries with highest year.</li>

</ol>

Misc:

This along with basic Curd Postgres operations are supported with ID based search.

pgadmin4-9.1-x86_64 : postgre16 is compatible with pgadmin 4.9 version. 

Select Database >>> Schemas >>> Query Tool

Then execute below command to get all tables in a database.

```shell
SELECT tablename FROM pg_tables WHERE schemaname = 'public';
```

```shell
mvn --version
```

```plaintext
Maven home: /usr/local/Cellar/maven/3.9.9/libexec
Java version: 21.0.7, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "12.3.1", arch: "x86_64", family: "mac"
```

```shell
java --version
```

```plaintext
java 21.0.7 2025-04-15 LTS
Java(TM) SE Runtime Environment (build 21.0.7+8-LTS-245)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.7+8-LTS-245, mixed mode, sharing)
```

### References
- https://sqlfiddle.com/postgresql/online-compiler?id=83ae1851-401a-48cc-a4a3-dddcff2f844a
- https://github.com/pfilaretov42/spring-data-jdbc-jsonb/blob/galaxy/src/main/kotlin/dev/pfilaretov42/spring/data/jdbc/jsonb/entity/FriendsEntity.kt
- https://vladmihalcea.com/spring-jpa-dto-projection/
- https://thorben-janssen.com/spring-data-jpa-named-queries/
- https://junhyunny.github.io/spring-boot/jpa/junit/spring-data-jpa-group-by/
- https://github.com/Junhyunny/blog-in-action/blob/master/2021-06-22-spring-data-jpa-group-by/action-in-blog/src/main/java/blog/in/action/repository/ItemRepository.java
- https://dev.to/shikha_verma_1896/common-exceptions-in-spring-core-and-springmvc-3l69
