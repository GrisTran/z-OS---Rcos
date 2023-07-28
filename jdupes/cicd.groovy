node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/jdupesport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/jdupesport.git'), string(name: 'PORT_DESCRIPTION', value: 'jdupes is a program for identifying and taking actions upon duplicate files such as deleting, hard linking, symlinking, and block-level deduplication.' )]
  }
}
