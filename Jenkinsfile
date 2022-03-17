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
        node(label: 'built-in') {
          sh 'pwd'
          sh 'mvn clean install -DskipTests'
        }

      }
    }

    stage('Run tests') {
      parallel {
        stage('Run test #1') {
          steps {
            node(label: 'Node1') {
              echo 'Executing first test'
              sh 'mvn test -Dtest="BlueOceanTest#firstTest"'
            }

          }
        }

        stage('Run test#2') {
          steps {
            node(label: 'Node2') {
              echo 'Executing second test'
              sh '''mvn test -Dtest="BlueOceanTest#secondTest"
'''
            }

          }
        }

        stage('Run test #3') {
          steps {
            echo 'Executing third test'
            sh 'mvn test -Dtest="BlueOceanTest#thirdTest"'
          }
        }

      }
    }

    stage('Clean workspace') {
      parallel {
        stage('Clean workspace') {
          steps {
            node(label: 'MacOSAgent') {
              cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanupMatrixParent: true, deleteDirs: true)
            }

          }
        }

        stage('Clean workspace node1') {
          steps {
            node(label: 'Node1') {
              cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanupMatrixParent: true, deleteDirs: true)
            }

          }
        }

        stage('Clean workspace node2') {
          steps {
            node(label: 'Node2') {
              cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanupMatrixParent: true, deleteDirs: true)
            }

          }
        }

        stage('Clean workspace node3') {
          steps {
            node(label: 'Node3') {
              cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenSuccess: true, cleanupMatrixParent: true, deleteDirs: true)
            }

          }
        }

      }
    }

  }
  environment {
    ENV_VARIABLE1 = 'ENV_VALUE1'
    ENV_VARIABLE2 = 'ENV_VALUE2'
  }
}