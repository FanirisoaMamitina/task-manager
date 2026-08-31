pipeline {

    agent any

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9'
    }

    stages {

        stage('Test') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
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