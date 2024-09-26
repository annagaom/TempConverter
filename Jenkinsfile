pipeline {
    agent any  // Use "any" to allow Jenkins to pick any available agent
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_credentials'
        DOCKERHUB_REPO = 'annagaom/temp_converter_demo'
        DOCKER_IMAGE_TAG = 'latest'
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
    }
    stages {
        stage('Check Docker Installation') {
            steps {
                sh 'docker --version'
            }
        }
        stage('Checkout') {
            steps {
                git 'https://github.com/annagaom/TempConverter.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }

        }
    }
}
