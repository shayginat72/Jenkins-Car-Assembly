pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'rm -rf buildJenkins'
                sh 'mkdir buildJenkins'
                sh 'touch buildJenkins/car.txt'
                sh 'echo "chassis" >> buildJenkins/car.txt'
                sh 'echo "engine" >> buildJenkins/car.txt'
                sh 'echo "body" >> buildJenkins/car.txt'
                sh 'echo "please rebuild meeeeeee'
            }
        }
        stage('Test'){
            steps{
                sh 'test -f buildJenkins/car.txt'
                sh 'grep "chassis" buildJenkins/car.txt'
                sh 'grep "engine" buildJenkins/car.txt'
                sh 'grep "body" buildJenkins/car.txt'
            }
        }
        stage('Publish'){
            steps {
                archiveArtifacts artifacts: 'buildJenkins/'
            }
        }
    }
}
