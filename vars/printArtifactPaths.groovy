def call(def pathDictionary){
    pathDictionary.each{ k, v ->
        echo "Artifact Type = " + k
        for(def i=0;i<v.size();i++){
            echo "Location: " + v[i]
        }
    }
}