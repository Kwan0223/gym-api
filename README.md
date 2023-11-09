# Gym API

안녕하세요! 'Gym API'는 체육관 관리를 위한 RESTful API 서비스입니다.

## 시작하기 (Getting Started)

이 프로젝트의 코드를 로컬 머신으로 가져오기 위해, 아래의 명령어를 사용하여 깃 클론을 진행하세요. `{branch_name}`에는 본인이 작업하고자 하는 브랜치명을 입력합니다.

git clone https://github.com/Kwan0223/gym-api.git -b {branch_name}

## 프로젝트환경(Project Environment)

이 프로젝트는 다음 환경에서 실행됩니다:

OpenJDK: 11
Spring Boot: 2.6.3
Gradle: 7.6.1

## 환경 설정

애플리케이션을 실행하기 전에, 루트 프로젝트에 있는 `gradle.properties` 파일을 참고하여 개인의 환경에 맞는 프로필 프로퍼티 파일을 생성해야 합니다.

프로필 프로퍼티 파일은 `gradle.properties` 파일과 동일한 위치에 설정해야 합니다. 파일 이름은 사용하는 환경 프로필에 맞춰 아래와 같이 생성하면 됩니다:

- 로컬 개발 환경: `gradle.local.properties`
- 개발 환경: `gradle.dev.properties`
- 프로덕션 환경: `gradle.prod.properties`

각 환경에 맞는 프로퍼티 파일을 설정한 후, IntelliJ와 같은 IDE에서 부분 수정 실행을 통해 프로젝트를 진행할 수 있습니다.

## Gradle을 이용한 실행 방법

프로젝트를 실행하기 전에, 루트 프로젝트 경로로 이동하세요. 그리고 사용 중인 운영체제(OS) 및 실행하려는 환경에 맞는 명령어를 사용합니다.

### Linux 또는 macOS

- ./gradlew :bootRun --args='--spring.profiles.active=local' # 로컬 환경
- ./gradlew :bootRun --args='--spring.profiles.active=dev'   # 개발 환경
- ./gradlew :bootRun --args='--spring.profiles.active=prod'  # 프로덕션 환경

### Window
- gradlew :bootRun --args='--spring.profiles.active=local' # 로컬 환경
- gradlew :bootRun --args='--spring.profiles.active=dev'   # 개발 환경
- gradlew :bootRun --args='--spring.profiles.active=prod'  # 프로덕션 환경
