List<String> lineas;
       try {
            Path path = Paths.get("preguntas.csv");
            lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
       } catch (IOException ex) {
            throw new RuntimeException ("Error I/O"+ ex.getMessage());
       }
String[] partes = new String[7];       //CSV de 7 elem por linea
for (String linea : lineas) {
   partes = linea.split(";");
   // partes[0]    número de pregunta
   // partes[1]    texto de la pregunta 
