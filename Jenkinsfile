//CREATES THE PROJECT's DOCKER IMAGE
pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("melinasandoval/docker-jenkins-practice")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}

// pipeline {
//     agent any
//     stages {
//         stage('Build Jar') {
//             steps {
//                 bat "mvn clean package -DskipTests"
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 bat "docker build -t='melinasandoval/docker-jenkins-practice' ."
//             }
//         }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
// 			        bat "docker login --username=${user} --password=${pass}"
// 			        bat "docker push melinasandoval/docker-jenkins-practice:latest"
// 			    }
//             }
//         }
//     }
// }