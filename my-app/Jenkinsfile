pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
              sh 'cd my-app && mvn compile'
            }
        }
        stage('Test'){
            steps{
            	 sh 'cd my-app && mvn test'
          		echo 'hello from myapp automated!!'
            }
        }
        stage('Publish'){
            steps {
               echo 'great success'
            }
        }
    }
}
