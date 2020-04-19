pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build maven from another branch') {
            steps {
                echo "hello from another branch"
                sh 'mvn clean verify'
            }
        }
        stage('Collect tests reports') {
            steps {
                junit testResults: 'target/surefire-reports/*.xml'
                cucumber fileIncludePattern: '**/cucumber.json'
            }
        }
    }
}
