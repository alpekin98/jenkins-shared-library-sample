def call(String paths){
    def artifacts = paths.split(";")
    for(i=0;i<artifacts.length;i++){
        def artifactType = artifacts[i].split("=")[0]
        def artifactArrayString = artifacts[i].split("=")[1]
        artifactArrayString = artifactArrayString - "[" - "]"
        if(artifactArrayString.contains(',')){
            def dirsArray = artifactArrayString.split(",")
            echo "Artifact Type = " + artifactType
            for(j=0;j<dirsArray.length;j++){
                echo "Location: " + dirsArray[j]
            }
        } else {
            echo "Artifact Type = " + artifactType
            echo "Location: " + artifactArrayString
        }
    }
}