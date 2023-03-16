# maven private repo on s3 - project that uses the library

## settings.xml
Add on ~/.m2/settings.xml repo's AWS credentials, like:

	<?xml version="1.0" encoding="UTF-8"?>
	<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
		<servers>
			<server>
				<id>my-mvn-repo.snapshot</id>
				<username>ACCESS_KEY</username>
				<password>SECRET_KEY</password>
			</server>
			<server>
				<id>my-mvn-repo.release</id>
				<username>ACCESS_KEY</username>
				<password>SECRET_KEY</password>
			</server>
		</servers>
	</settings>

## pom.xml
On pom.xml add:

    	<repositories>
		<repository>
			<id>my-mvn-repo.snapshot</id>
			<url>s3://my-mvn-repo/snapshot</url>
		</repository>
		<repository>
			<id>my-mvn-repo.release</id>
			<url>s3://my-mvn-repo/release</url>
		</repository>
	</repositories>
	...
	<dependencies>
		<dependency>
			<groupId>olly-it</groupId>
			<artifactId>mvn-java-library</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
	</dependencies>
	...
	<build>
        <extensions>
            <extension>
                <groupId>com.github.seahen</groupId>
                <artifactId>maven-s3-wagon</artifactId>
                <version>1.3.3</version>
            </extension>
        </extensions>
	</build>
	
