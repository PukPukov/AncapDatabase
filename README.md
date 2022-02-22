
# AncapDatabase

API для работы с базами данных на Bukkit. 

## Использование с помощью Maven
     <repository>  
	     <id>AncapDatabase-mvn-repo</id>  
	     <url>https://raw.github.com/PukPukov/AncapDatabase/mvn-repo/</url>  
	     <snapshots> 
		     <enabled>true</enabled>  
		     <updatePolicy>always</updatePolicy>  
	     </snapshots>
     </repository>
     
     <dependencies>  
	     <dependency> 
		     <groupId>org.spigotmc</groupId>  
		     <artifactId>spigot-api</artifactId>  
		     <version>1.16.5-R0.1-SNAPSHOT</version>  
		     <scope>provided</scope>  
	     </dependency>  
	     <dependency> 
		     <groupId>ru.pukpukov</groupId>  
		     <artifactId>AncapLibrary</artifactId>  
		     <version>1.0-SNAPSHOT.1</version>  
		     <scope>provided</scope>  
		 </dependency>  
	     <dependency>
		     <groupId>ru.pukpukov</groupId>  
		     <artifactId>AncapDatabase</artifactId>  
		     <version>alpha.1.0.0.1</version>  
		     <scope>provided</scope>  
	     </dependency>  
     </dependencies>
## Использование БД AncapLibrary
AncapLibrary по дефолту при установке создаёт базу данных. Рекомендуется использовать именно эту базу данных при использовании AncapDatabase.

    Database database = AncapLibrary.getConfiguredDatabase();
    database.write(path, value);
    database.getString(path);
