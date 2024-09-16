pipeline {
    agent any
    tools {
        maven 'HomeBrew Maven'  // Ensure Maven is installed
        jdk 'jdk-20'     // Ensure JDK is installed
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/annagaom/TempConverter.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/TEST-TemperatureConverterTest.xml'  // Capture test reports
                }
            }
        }
        stage('Code Coverage Report') {
            steps {
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    jacoco execPattern: 'target/jacoco.exec'
                }
            }
        }
    }
}

