node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'ws-ocp', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'ws-ocp')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5
    }
}
