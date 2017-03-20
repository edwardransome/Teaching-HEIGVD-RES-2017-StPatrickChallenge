package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * This class is responsible for providing different types of Stream Processors.
 *
 * @author Olivier Liechti
 */
public class StreamProcessorsFactory implements IStreamProcessorsFactory {

    @Override
    public IStreamProcessor getProcessor() {
        return new BasicStreamProcessor();
    }

    @Override
    public IStreamProcessor getProcessor(String processorName) throws UnknownNameException {
        switch (processorName) {
            case "e-remover":
                return new IStreamProcessor() {
                    public void process(Reader in, Writer out) throws IOException {
                        BufferedReader br = new BufferedReader(in);
                        BufferedWriter bw = new BufferedWriter(out);
                        int c = br.read();
                        while (c != -1) {
                            if((char)c != 'e' && (char)c != 'E'){
                                bw.write(c);
                            }
                            c = br.read();
                        }
                        bw.flush();
                    }
                };
            default:

        }
        throw new UnknownNameException("The factory does not know any processor called " + processorName);

    }

}
