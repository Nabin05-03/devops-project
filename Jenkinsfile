pipeline {
    agent any
tools {
    maven 'Maven3'
}
    stages {
        stage('Checkout') {
    steps {
        checkout scm
        echo 'Project downloaded from GitHub'
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
        stage('Docker Build') {
    steps {
       bat '"C:\\Users\\ghimi\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t devops-project .'
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
