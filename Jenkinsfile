pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh "docker build -t gym-api:latest ./"
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    // 컨테이너가 실행 중인지 확인
                    def isRunning = sh(script: "docker ps -q --filter 'name=gym-api-container'", returnStatus: true) == 0
                    if (isRunning) {
                        sh "docker stop gym-api-container"
                    }
                    // 컨테이너가 존재하는지 확인
                    def exists = sh(script: "docker ps -a -q --filter 'name=gym-api-container'", returnStatus: true) == 0
                    if (exists) {
                        sh "docker rm gym-api-container"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh "docker run -d --name gym-api-container -p 80:8080 gym-api:latest"
            }
        }
    }
}
