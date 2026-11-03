
pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven3'
    }

    stages {

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
                bat '"C:\\Users\\ghimi\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t nabin0503/devops-project:latest .'
            }
        }

        stage('Docker Hub Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat '''
                        @echo off
                        "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe" -NoProfile -ExecutionPolicy Bypass -Command "$env:DOCKER_PASS | & 'C:\\Users\\ghimi\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe' login -u $env:DOCKER_USER --password-stdin; if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }; & 'C:\\Users\\ghimi\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe' push nabin0503/devops-project:latest; exit $LASTEXITCODE"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Docker Hub push completed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }
    }
}

