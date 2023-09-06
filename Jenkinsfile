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
                    // 컨테이너가 존재하는지 확인
                    def exists = sh(script: "docker ps -a -q --filter 'name=gym-api'", returnStatus: true) == 0
                    if (exists) {
                        // 컨테이너가 실행 중이면 중지
                        sh "docker stop gym-api || true"
                        // 컨테이너 삭제
                        sh "docker rm gym-api || true"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh "docker run -d --name gym-api -p 80:8080 gym-api:latest"
            }
        }
    }
}

