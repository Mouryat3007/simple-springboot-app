# Simple Spring Boot Application

This is a minimal Spring Boot application that serves a "Hello, World!" message at the root endpoint (`/`). It is designed to be simple and straightforward for demonstration purposes.

## Getting Started

### Prerequisites

- **Java 17**: Ensure you have Java 17 installed.
- **Maven**: You need Maven to build the project.

#### Install Java

$ sudo apt install openjdk-17-jdk

#### Download, Install Maven and Set PATH

$ cd /tmp; wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
$ tar xvf apache-maven-3.9.9-bin.tar.gz
$ mv apache-maven-3.9.9 /opt/maven
$chown -R root:root /opt/maven

$ cat <<EOF >> /etc/profile.d/mymavenvars.sh
export JAVA_HOME=/usr/lib/jvm/default-java
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
EOF

$ ln -s /opt/maven/bin/mvn /usr/bin/mvn
$ mvn --version

### Clone the project
$ git clone https://github.com/Mouryat3007/simple-springboot-app.git

### Building the Project

To build the project, navigate to the root directory of the project and run:

$ cd simple-springboot-app

```bash
mvn clean package
