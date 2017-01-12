- Para desplegar en TomEE es necesario configurar el acceso a base de datos en el archivo tomee.xml.
- Previamente se debe agregar a la carpeta lib/ el conector para MySql
<Resource id="GuiaVentasDS" type="javax.sql.DataSource">
	    jdbcDriver = com.mysql.jdbc.Driver
	    jdbcUrl =  jdbc:mysql://localhost/test_db
	    jtaManaged = true
	    maxActive = 20
	    maxIdle = 20
	    maxWaitTime = -1 millisecond
	    minEvictableIdleTime = 30 minutes
	    minIdle = 0
	    numTestsPerEvictionRun = 3
	    password = 
	    passwordCipher = PlainText
	    testOnBorrow = true
	    testOnReturn = false
	    testWhileIdle = false
	    timeBetweenEvictionRuns = -1 millisecond
	    userName = root
	    validationQuery = SELECT * FROM USER 
</Resource>



