pipeline {

    agent any

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9'
    }

    stages {

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

        stage('Deploy') {
            steps {
                bat '''
                    if not exist "C:\\Deploy\\task-manager" mkdir "C:\\Deploy\\task-manager"

                    copy /Y "target\\task-manager-1.0-SNAPSHOT.jar" "C:\\Deploy\\task-manager\\task-manager.jar"
                '''
            }
        }
    }
}