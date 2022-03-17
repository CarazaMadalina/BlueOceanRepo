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
          sh 'pwd'
          sh 'mvn clean install -DskipTests'
        }

      }
    }

    stage('Clean workspace') {
      steps {
        node(label: 'MacOSAgent') {
          cleanWs(cleanWhenAborted: true, cleanWhenSuccess: true, cleanupMatrixParent: true, deleteDirs: true)
        }

      }
    }

  }
  environment {
    ENV_VARIABLE1 = 'ENV_VALUE1'
    ENV_VARIABLE2 = 'ENV_VALUE2'
  }
}