pipeline {
  agent any
  stages {
    stage('Preparing the environment') {
      steps {
        node(label: 'built-in') {
          echo 'Preparing the environment...'
        }

      }
    }

    stage('Build project') {
      steps {
        node(label: 'MacOSAgent') {
          sh 'rm -rf BlueOceanRepo && git clone https://github.com/CarazaMadalina/BlueOceanRepo.git && cd BlueOceanRepo && mvn clean install -DskipTests'
        }

      }
    }

    stage('Run tests') {
      parallel {
        stage('Run test #1') {
          steps {
            node(label: 'MacOSAgent') {
              echo 'Executing first test'
              sh 'pwd && mvn test -Dtest="BlueOceanTest#firstTest"'
            }

          }
        }

        stage('Run test#2') {
          steps {
            node(label: 'MacOSAgent') {
              echo 'Executing second test'
              sh 'pwd && mvn test -Dtest="BlueOceanTest#secondTest"'
            }

          }
        }

        stage('Run test #3') {
          steps {
            node(label: 'MacOSAgent') {
              echo 'Executing third test'
              sh 'pwd && mvn test -Dtest="BlueOceanTest#thirdTest"'
            }

          }
        }

      }
    }

    stage('Save results') {
      steps {
        node(label: 'MacOSAgent') {
          writeFile(file: 'test_execution.log', text: ' Test execution: ENV_VARIABLE1 and ENV_VARIABLE2')
          sh 'echo ENV_VARIABLE1 is ${ENV_VARIABLE1} >> test_execution.log && echo ENV_VARIABLE2 is ${ENV_VARIABLE2} >> test_execution.log'
        }

      }
    }

    stage('Publish results') {
      steps {
        node(label: 'MacOSAgent') {
          archiveArtifacts '**/*.log'
          junit(allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml')
          realtimeJUnit(testResults: '**/target/surefire-reports/TEST-*.xml')
        }

      }
    }

  }
  environment {
    ENV_VARIABLE1 = 'ENV_VALUE1'
    ENV_VARIABLE2 = 'ENV_VALUE2'
  }
}