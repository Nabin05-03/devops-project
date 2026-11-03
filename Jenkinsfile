
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
            powershell '''
                $ErrorActionPreference = "Stop"
                $docker = "C:\\Users\\ghimi\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe"

                $env:DOCKER_PASS | & $docker login -u $env:DOCKER_USER --password-stdin

                if ($LASTEXITCODE -ne 0) {
                    exit $LASTEXITCODE
                }

                & $docker push nabin0503/devops-project:latest

                if ($LASTEXITCODE -ne 0) {
                    exit $LASTEXITCODE
                }
            '''
        }
    }
}
