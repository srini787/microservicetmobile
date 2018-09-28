node{
stage('scm checkout'){
git 'https://github.com/srini787/microservicetmobile.git'
}
 stage('mvn build'){
  def shell(command) {
    return bat(returnStdout: true, script: "sh -x -c \"${command}\"").trim()
}
   def mvn_Home = tool name: 'M3', type: 'maven'
   sh "{mvn_Home}/bin/mvn package"
}
}
