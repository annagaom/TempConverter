pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_credentials'
        DOCKERHUB_REPO = 'annagaom/temp_converter_demo'
        DOCKER_IMAGE_TAG = 'latest'
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/annagaom/TempConverter.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def image = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('List Docker Images') {
            steps {
                script {
                    sh 'docker images'
                }
            }
        }

        stage('Check Docker Version') {
            steps {
                script {
                    sh 'docker --version'
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', DOCKERHUB_CREDENTIALS_ID) {
                        echo "Pushing image: ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
