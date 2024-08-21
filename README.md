# Simple Spring Boot Application

This is a minimal Spring Boot application that serves a "Hello, World!" message at the root endpoint (`/`). It is designed to be simple and straightforward for demonstration purposes.

## Getting Started

### Prerequisites

- **Java 17**: Ensure you have Java 17 installed.
- **Maven**: You need Maven to build the project.

#### Install Java

```bash
 sudo apt install openjdk-17-jdk
```

#### Download, Install Maven and Set PATH

```bash
 cd /tmp; wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
```
```bash
 tar xvf apache-maven-3.9.9-bin.tar.gz
```
```bash
 mv apache-maven-3.9.9 /opt/maven
```
```bash
chown -R root:root /opt/maven
```
```bash
 cat <<EOF >> /etc/profile.d/mymavenvars.sh
export JAVA_HOME=/usr/lib/jvm/default-java
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
EOF
```
```bash
 ln -s /opt/maven/bin/mvn /usr/bin/mvn
```
Check Maven version which will also show Java Homepath
```bash
 mvn --version
```
### Clone the project

```bash
$ git clone https://github.com/Mouryat3007/simple-springboot-app.git
```

### Building the Project

To build the project, navigate to the root directory of the project and run:

```bash
$ cd simple-springboot-app
```
```bash
$ mvn clean package
```
### Run the Jar file from the target folder

```bash
$ java -jar target/demo-0.0.1-SNAPSHOT.jar
```
### Check on local 

## http://localport:8080/

### Build Docker Image

```bash
docker build -t springboot .
```

### Steps to Push Docker Image to a Repository
1. Login to Docker Hub or Private Registry
```bash
docker login
```
Enter your Docker Hub username and password when prompted.

2. Tag Your Docker Image
To tag your image, use the format <repository>/<image>:<tag>. Here’s how you can do it:

```bash
docker tag <local-image>:<local-tag> <dockerhub-username>/<repository>:<tag>
```

Example
```bash
docker tag simple-spring-boot-app:latest yourusername/simple-spring-boot-app:latest
```
3. Push the Docker Image
```bash
 docker push <dockerhub-username>/<repository>:<tag>
```
### You can also create a CI/CD pipeline 
The script is included in the repo
Copy paste the script in the jenkins job pipeline while creating a job
Add docker credentials as username and password in jenkins
ID and description = docker

### Jenkins 
Under general select GitHub project from options below
> paste your github URL 
> In Build Triggers section select GitHub hook trigger for GITScm polling

### webhook
Go to your github repo and click on settings
> click on webhook and add webhook
> add your url in Payload URL *
  http://<>your-jenkins-url/github-webhook/

## When ever there are changes in the github Repo the build is automatically trigged in jenkins
