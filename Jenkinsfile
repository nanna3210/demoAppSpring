pipeline {
    agent any  // Runs on any available Jenkins agent

    tools {
        maven 'M2_HOME'     // Must match Maven tool name in Jenkins
        jdk 'JAVA_HOME'     // Must match JDK tool name in Jenkins
    }

    environment {
        SONAR_HOST_URL = 'https://cb2c-2406-7400-51-b68f-bc5a-e904-d7d8-6b9a.ngrok-free.app'  // Your SonarQube server IP
        SONAR_LOGIN_TOKEN = credentials('sonar-token')  // SonarQube Token stored in Jenkins
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                git branch: 'master', url: 'https://github.com/nanna3210/demoAppSpring.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    try {
                        sh 'mvn clean install'  // Build and run tests
                    } catch (Exception e) {
                        echo "Build failed: ${e}"
                        error "Stopping pipeline due to build failure."
                    }
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') { // SonarQube must be configured in Jenkins
                    sh """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=myproject \
                        -Dsonar.host.url=$SONAR_HOST_URL \
                        -Dsonar.login=$SONAR_LOGIN_TOKEN
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 3, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Quality Gate failed: ${qualityGate.status}"
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline executed successfully! ✅"
        }
        failure {
            echo "Pipeline failed! ❌"
        }
    }
}
