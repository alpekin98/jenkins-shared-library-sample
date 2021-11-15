def call(Map pathDictionary){
    pathDictionary.each{ k, v ->
        echo "Artifact Type = " + k
        for(def i=0;i<v.size();i++){
            echo "Location: " + v[i]
            pushToArtifactory(v[i])
        }
    }
}

def pushToArtifactory(String artifactPath){
    def splitted = artifactPath.split("/")
    def artifactName = splitted[splitted.length-1]
    def artifactType = splitted[splitted.length-2]
    sh "curl -u arinc.alp.98@gmail.com:AP7y8ekbLckRdzX7RZYYFbU717x -XPUT 'https://alpekin98.jfrog.io/artifactory/my-test-debian/pool/${artifactType}/${artifactName};deb.distribution=latest;deb.component=main;deb.architecture=amd64' -T ${artifactPath}"
}