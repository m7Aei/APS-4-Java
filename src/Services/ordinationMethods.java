package Services;

import Database.*;
import Controllers.ImageController;

public class ordinationMethods {
    ImageController images = new ImageController();

    // Criando o metodo burble sort
    public void insertionSort (int array[]) {
        images.index();
        int tamanhoArray = images.index().size();
        for (int var = 1; var < tamanhoArray; var++) {
            int insertion = array[var];
            int i = var - 1;
            while ((i > -1) && (array [i] > insertion)) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = insertion;
        }
    }
}
