def call(Map config = [:]){
    sh "echo Merhaba ${config.name}. Kütüphaneden sesleniyorum."
}