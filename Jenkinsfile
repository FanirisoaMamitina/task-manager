pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }
}