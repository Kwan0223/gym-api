// Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any 	// 사용 가능한 에이전트에서 이 파이프라인 또는 해당 단계를 실행
    stages {
        stage('Build') {
            steps {
                    sh "docker build -t gym-api:latest ./"

            }
        }

        stage('Deploy') {
            steps {
                    sh "docker run -d --name gym-api-container -p 80:8080 gym-api:latest"

            }
        }
    }
}