def call(Map pathDictionary){
    pathDictionary.each{ k, v ->
        echo "Artifact Type = " + k
        for(def i=0;i<v.size();i++){
            echo "Location: " + v[i]
            pushToArtifactory(v[i],k)
        }
    }
}

def pushToArtifactory(String artifactPath, String artifactType){
    def splitted = artifactPath.split("/")
    def artifactName = splitted[splitted.length-1]
    sh "curl -u ${ARTIFACTORY_CREDENTIALS} -XPUT '${ARTIFACTORY_URL}/${artifactType}/${artifactName}' -T ${artifactPath}"
}