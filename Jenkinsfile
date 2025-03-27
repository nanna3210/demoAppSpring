pipeline {
    agent any  // Runs on any available Jenkins agent

    tools {
        maven 'M2_HOME'  // Use Maven installed in Jenkins
        jdk 'JAVA_HOME'  // Use JDK installed in Jenkins
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/nanna3210/demoAppSpring.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean install'  // Build and run tests
            }
        }
    }
}
