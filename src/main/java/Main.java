import com.googlecode.fannj.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yury on 11.12.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/home/yury/BSTU/lab3/mainComponentsTrain.txt"));
        String str;
        File test = new File("newFile.txt");
        FileWriter f = new FileWriter(test);
        while ( (str = in.readLine()) != null) {
            String newStr = str.replace(".",",");
            f.append(newStr + "\n");
        }
        f.close();
        List<Layer> layerList = new ArrayList<Layer>();
        layerList.add(Layer.create(10, ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        layerList.add(Layer.create(20,  ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        layerList.add(Layer.create(1,  ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        Fann fann = new Fann(layerList);
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        trainer.train("newFile.txt",500, 1, 0.00001f);
        fann.save("ann");
    }
}
