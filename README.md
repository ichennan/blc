# blc
by chennan

### step 1: original  

download demo from official website  
version is DemoSite-broadleaf-5.2.4-GA  

```
cd ../blc
mvn install

cd ../blc/admin
mvn spring-boot:run

cd ../blc/site
mvn spring-boot:run

cd ../blc/api
mvn spring-boot:run
```

http://localhost:8081/admin  
http://localhost:8080  
http://localhost:8082/api/v1/swagger-ui.html  

### step 2: mysql  

#### 2.1 replace  

```
<dependency>
    <groupId>com.broadleafcommerce</groupId>
    <artifactId>broadleaf-boot-starter-hsql-database</artifactId>
</dependency>
```

by  

```
<dependency>
    <groupId>com.broadleafcommerce</groupId>
    <artifactId>broadleaf-boot-starter-database</artifactId>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

#### 2.2 remove  

```
blPU.hibernate.hbm2ddl.import_files_sql_extractor=org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor
blSecurePU.hibernate.hbm2ddl.import_files_sql_extractor=org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor
blCMSStorage.hibernate.hbm2ddl.import_files_sql_extractor=org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor
blEventPU.hibernate.hbm2ddl.import_files_sql_extractor=org.broadleafcommerce.common.util.sql.importsql.DemoHsqlSingleLineSqlCommandExtractor
```  

#### 2.3 remove

```
blPU.hibernate.dialect=org.broadleafcommerce.common.dialect.DemoHSQLDialect
blCMSStorage.hibernate.dialect=org.broadleafcommerce.common.dialect.DemoHSQLDialect
blSecurePU.hibernate.dialect=org.broadleafcommerce.common.dialect.DemoHSQLDialect
blEventPU.hibernate.dialect=org.broadleafcommerce.common.dialect.DemoHSQLDialect
```

#### 2.4 add

```
blPU.hibernate.hbm2ddl.auto=update
blEventPU.hibernate.hbm2ddl.auto=update
blSecurePU.hibernate.hbm2ddl.auto=update
blCMSStorage.hibernate.hbm2ddl.auto=update
blPU.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
blCMSStorage.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
blSecurePU.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
blEventPU.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```

to   
../blc/admin/resources/runtime-properties/default.properties  
../blc/site/resources/runtime-properties/default.properties  
../blc/api/resources/runtime-properties/default.properties  

#### 2.5 add  

```
database.user=root
database.password=Root123.
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/broadleaf?useUnicode=true&amp;characterEncoding=utf8
```

to  
../blc/admin/resources/runtime-properties/common.properties  
../blc/site/resources/runtime-properties/common.properties  
../blc/api/resources/runtime-properties/common.properties  

#### 2.6 init

set 

```
blPU.hibernate.hbm2ddl.auto=create
blEventPU.hibernate.hbm2ddl.auto=create
blSecurePU.hibernate.hbm2ddl.auto=create
blCMSStorage.hibernate.hbm2ddl.auto=create
```

in 
../blc/admin/resources/runtime-properties/default.properties 

when first time run  

```
cd ../blc/admin
mvn spring-boot:run
```  

it will create all the tables and then change it back to  

```
blPU.hibernate.hbm2ddl.auto=update
blEventPU.hibernate.hbm2ddl.auto=update
blSecurePU.hibernate.hbm2ddl.auto=update
blCMSStorage.hibernate.hbm2ddl.auto=update
```


#### 2.7 mvn spring-boot run to start

```
cd ../blc/admin
mvn spring-boot:run

cd ../blc/site
mvn spring-boot:run

cd ../blc/api
mvn spring-boot:run
```

#### notes

it recommend not using mysql 5.7, but i try and it works.  




