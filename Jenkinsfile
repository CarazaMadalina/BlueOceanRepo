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
          writeFile(file: 'test_execution.log', text: 'Execution of the tests')
        }

      }
    }

    stage('Publish results') {
      steps {
        node(label: 'MacOSAgent') {
          archiveArtifacts '**/*.log'
        }

      }
    }

  }
  environment {
    ENV_VARIABLE1 = 'ENV_VALUE1'
    ENV_VARIABLE2 = 'ENV_VALUE2'
  }
}