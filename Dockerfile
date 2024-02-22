FROM amazoncorretto:17.0.10-alpine
WORKDIR /app
COPY target/DataNasabah-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

## gambar dasar
 # DARI amazoncorretto : 17
 #
 ## jalur file JAR
 # ARG JAR_FILE = target/*.jar
 #
 ## Salin file JAR dari konteks build ke gambar Docker
 # COPY $ {JAR_FILE } application.jar
 #
 #CMD apt-get update -y
 #
 ## Tetapkan perintah default untuk menjalankan aplikasi Java
 # ENTRYPOINT [ "java" , "-Xmx2048M" , "-jar" , "/application.jar" ]