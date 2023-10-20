node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/procpsport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/procpsport.git'), string(name: 'PORT_DESCRIPTION', value: 'procps is a set of command line and full-screen utilities that provide information out of the pseudo-filesystem most commonly located at /proc.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
