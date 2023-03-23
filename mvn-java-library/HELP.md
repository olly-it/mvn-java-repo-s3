# maven private repo on s3 - library part

## s3 bucket
Take a look here: https://nuvalence.io/insights/using-an-s3-bucket-as-a-maven-repository/

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

These credentials must match with s3's bucket policies (r/w/...)

## pom.xml
On pom.xml add:

    <build>
        <extensions>
            <extension>
                <groupId>com.github.seahen</groupId>
                <artifactId>maven-s3-wagon</artifactId>
                <version>1.3.3</version>
            </extension>
        </extensions>
    </build>
    ...
    <distributionManagement>
		<snapshotRepository>
			<id>my-mvn-repo.snapshot</id>
			<url>s3://my-mvn-repo/snapshot</url>
		</snapshotRepository>
		<repository>
			<id>my-mvn-repo.release</id>
			<url>s3://my-mvn-repo/release</url>
		</repository>
	</distributionManagement>
	...


## build a version

    > mvn clean deploy
    
NOTE: Maven checks the pom.xml file for the version tag, and if it includes “SNAPSHOT” your package will be put in the snapshot folder, otherwise it will be added to the release folder. And just like that, your code is out there for others to use.
