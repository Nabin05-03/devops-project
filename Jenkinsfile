pipeline {
    agent any
tools {
    maven 'Maven3'
}
    stages {
        stage('Checkout') {
            steps {
                echo 'Getting project from GitHub'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
