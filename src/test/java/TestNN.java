import com.googlecode.fannj.Fann;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yury on 11.12.16.
 */
public class TestNN {
    @Test
    public void test() throws IOException {
        Integer N = 211029;
        BufferedReader in = new BufferedReader(new FileReader("/home/yury/BSTU/lab3/mainComponentsTest.txt"));
        float[][] inData = new float[N][10];
        float[] outData = new float[N];
        Integer k = 0;
        String str;
        while ( (str = in.readLine()) != null) {
            String[] params = str.split(" ");
            float[] r = new float[10];
            for(int i=0;i<params.length;i++) {
                float t = Float.parseFloat(params[i]);
                r[i] = t ;
            }
            inData[k] = r;
            k++;
        }
        in.close();
        in = new BufferedReader( new FileReader("/home/yury/BSTU/lab3/main"));
        Object[] lines2 = new Object[N];
        for(int i=0;i<N;i++) {
            lines2[i] = in.readLine();
        }
        Fann fann = new Fann("ann");
        Integer f = 0;
        Integer d = 0;
        Integer c = 0;
        for (int i=0;i<N;i++){
            float s = fann.run(inData[i])[0];
            float q = Float.parseFloat(lines2[i].toString());
            if ( s > 0.3 && q == 1) f++;
            if( s < 0.3 && q == 1) d++;
            if(q == 1)   c++;
        }
        System.out.println(f);
        System.out.println(d);
        //System.out.println(c);
    }
    }
