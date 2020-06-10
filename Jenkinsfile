pipeline {
    agent any
    tools {
        maven 'Maven 3.5.2'
        jdk 'Java 9'
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn package'
            }
        }

        stage ('Deploy to Octopus') {
            steps {
                withCredentials([string(credentialsId: 'OctopusAPIKey', variable: 'APIKey')]) {
                    bat """
                        "C:\Program Files (x86)\Jenkins\tools\com.cloudbees.jenkins.plugins.customtools.CustomTool\Octo_CLI"/Octo push --package target/demo.0.0.1-SNAPSHOT.war --replace-existing --server http://guestserver.com  --apiKey ${APIKey}
                        "C:\Program Files (x86)\Jenkins\tools\com.cloudbees.jenkins.plugins.customtools.CustomTool\Octo_CLI"/Octo create-release --project "Thymeleaf Demo" --server http://guestserver.com --apiKey ${APIKey}
                        "C:\Program Files (x86)\Jenkins\tools\com.cloudbees.jenkins.plugins.customtools.CustomTool\Octo_CLI"/Octo deploy-release --project "Thymeleaf Demo" --version latest --deployto Integration --server http://guestserver.com --apiKey ${APIKey}
                    """
                }
            }
        }
    }
}
