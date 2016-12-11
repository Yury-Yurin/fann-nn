import com.googlecode.fannj.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yury on 11.12.16.
 */
public class MLP {
    public static void main(String[] args) {
        List<Layer> layerList = new ArrayList<Layer>();
        layerList.add(Layer.create(10, ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        layerList.add(Layer.create(20, ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        layerList.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC,0.01f));
        Fann fann = new Fann(layerList);
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        trainer.train("/home/yury/BSTU/lab3/mainComponentsTrain.txt",100000, 100, 0.0001f);
        fann.save("ann");
    }

}
