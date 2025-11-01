pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    environment {
        ARTIFACTORY_SERVER = 'jfrog-server'
        ARTIFACTORY_REPO = 'loginapp-repo'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'jfrog-local',
                    url: 'https://github.com/neymarjhon-bot/loginapp.git'
            }
        }

        stage('Compilar y Empaquetar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Subir JAR a JFrog') {
            steps {
                script {
                    def server = Artifactory.server(env.ARTIFACTORY_SERVER)
                    def buildInfo = Artifactory.newBuildInfo()
                    echo "📦 Subiendo artefacto JAR a JFrog Artifactory..."

                    server.upload(spec: """{
                        "files": [{
                            "pattern": "target/*.jar",
                            "target": "${ARTIFACTORY_REPO}/"
                        }]
                    }""", buildInfo: buildInfo)

                    server.publishBuildInfo(buildInfo)
                    echo "✅ JAR subido correctamente a ${ARTIFACTORY_REPO}"
                }
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completado con éxito. JAR disponible en Artifactory."
        }
        failure {
            echo "❌ Error durante la construcción o subida a JFrog."
        }
    }
}




