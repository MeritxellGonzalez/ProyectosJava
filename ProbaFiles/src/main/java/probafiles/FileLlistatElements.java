package probafiles;

import java.io.File;

public class FileLlistatElements {

    public static void main(String[] args) {
        FileLlistatElements prg = new FileLlistatElements();
        prg.inici();
    }

    public void inici() {
        File carpeta = new File("C:/Temp");
        File[] arrayElements = carpeta.listFiles();
        System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:");
        for (int i = 0; i < arrayElements.length; i++) {
            File f = arrayElements[i];
            if (f.isDirectory()) {
                System.out.println("[DIR] ");
            } else {
                System.out.println("[FIT]");
            }
            System.out.println(f.getName());
        }
    }
}
