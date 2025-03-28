pipeline {
    agent any

    environment {
        JENKINS_URL = 'http://localhost:8090'
        SONARQUBE_SERVER = 'http://localhost:9000'
        MYSQL_URL = 'jdbc:mysql://mysql:3306/springdb'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nanna3210/demoAppSpring.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Code Analysis with SonarQube') {
            steps {
                sh "./mvnw sonar:sonar -Dsonar.projectKey=spring-app -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=your-sonar-token"
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker build -t spring-app .'
                sh 'docker run -d --name spring-app --network dev-network -p 8081:8080 spring-app'
            }
        }
    }
}
