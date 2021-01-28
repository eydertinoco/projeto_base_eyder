node {

    def jdkHome
    def mvnHome
    def gitBranch

    stage('Check branch') {
        gitHome = git branch: 'master', credentialsId: 'indra', url: 'git@192.168.100.212:semge/projeto-base.git'
        gitBranch = sh returnStdout: true, script: "git branch"
    }

    if (gitBranch.contains('master')) {
        stage('Init') {
            jdkHome = tool 'JDK11'
            mvnHome = tool 'M3'

            env.PATH = "${jdkHome}/bin:${mvnHome}/bin:${env.PATH}"
        }

        stage('Check env') {
            sh "java -version"
            sh "mvn -v"
        }

        stage('Deploy') {
            sh "mvn -DskipTests=true -Dmaven.test.failure.ignore clean deploy"
            sh "rm -rf /opt/tomcat/wehapps/projetobase.war"
            sh "cp $WORKSPACE/target/*.war /opt/tomcat/webapps/projetobase.war"
            sleep 15
        }

    }

}