node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/libjodycodeport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/libjodycodeport.git'), string(name: 'PORT_DESCRIPTION', value: 'libjodycode is a software code library containing code shared among several of the programs written by Jody Bruchon such as imagepile, jdupes, winregfs, and zeromerge.' )]
  }
}
