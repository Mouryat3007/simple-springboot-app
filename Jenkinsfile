pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'mouryat3007/springboot:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git url: 'https://github.com/Mouryat3007/simple-springboot-app.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Ensure Maven is executed in the correct directory
                script {
                    sh '''
                    if [ -f pom.xml ]; then
                        echo "Running Maven in the current directory"
                        mvn clean package
                    else
                        echo "pom.xml not found. Please check the directory structure."
                        exit 1
                    fi
                    '''
                }
            }
        }

        stage('Test') {
            steps {
                // Run unit tests using Maven
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker', toolName: 'docker'){
                        sh "docker build -t springboot ."
                   }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Push the Docker image to DockerHub
                script {
                    withDockerRegistry(credentialsId: 'docker', toolName: 'docker'){
                    sh "docker tag springboot ${DOCKER_IMAGE}"
                    sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Remove Existing Container') {
            steps {
                // Stop and remove any existing Docker container
                sh "docker stop springboot || true"
                sh "docker rm springboot || true"
            }
        }

        stage('Deploy') {
            steps {
                // Run the new Docker container
                sh "docker run -dt --name springboot -p 9090:8080 ${DOCKER_IMAGE}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
