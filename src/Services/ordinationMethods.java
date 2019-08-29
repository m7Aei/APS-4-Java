package Services;

import Database.*;
import Controllers.ImageController;

public class ordinationMethods {
    ImageController images = new ImageController();

    // Criando o metodo burble sort
    public void burbleSort () {
        images.index();
        int maximo = 0;
        int i;
        int tamanhoArray = images.index().size();
        int arrayMenor = tamanhoArray - 1;

        for (i = 0; i < tamanhoArray; i++) {
            for (int y = 0; y < arrayMenor; y++) {
                 if (arrayMenor > arrayMenor + 1) {
                     maximo = arrayMenor;
                     arrayMenor += 1;
                     arrayMenor = maximo;
                 }
            }
        }
    }
}
