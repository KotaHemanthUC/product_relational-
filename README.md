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
