
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
## Использование БД AncapLibrary
AncapLibrary по дефолту при установке создаёт базу данных. Рекомендуется использовать именно эту базу данных при использовании AncapDatabase.

    Database database = AncapLibrary.getConfiguredDatabase();
    database.write(path, value);
    database.getString(path);
