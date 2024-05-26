package RegistroDeAlumnos;

public class TestCreateFile {

    public static void main(String[] args) {
        CreateFilesText aplicacion = new CreateFilesText();
        aplicacion.openFile();
        aplicacion.addRecords();
        aplicacion.closeFile();
    }

}
