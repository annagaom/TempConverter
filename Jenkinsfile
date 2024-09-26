pipeline {
    agent any  // Use "any" to allow Jenkins to pick any available agent

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_credentials' // Jenkins credentials ID for Docker Hub
        DOCKERHUB_REPO = 'annagaom/temp_converter_demo' // Docker Hub repository name
        DOCKER_IMAGE_TAG = 'latest' // Tag for the Docker image
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin" // Ensure the PATH is set correctly
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git 'https://github.com/annagaom/TempConverter.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    def image = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Log in to Docker Hub and push the image
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        // Push the image to Docker Hub
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
