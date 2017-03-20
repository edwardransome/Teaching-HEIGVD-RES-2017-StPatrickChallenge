package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

class NoAStreamDecoratorController implements IStreamDecoratorController{

    public NoAStreamDecoratorController() {
    }

    @Override
    public Reader decorateReader(Reader inputReader) {
        
        return inputReader;
//        return new BufferedReader(inputReader){
//            @Override
//            public int read() throws IOException{
//                int c = inputReader.read();
//                while((char)c == 'a' || (char)c == 'A'){
//                    c = inputReader.read();
//                    
//                }
//                return c;
//            }
//        };
    }

    @Override
    public Writer decorateWriter(Writer outputWriter) {
        return new BufferedWriter(outputWriter){
            @Override
            public void write(int c) throws IOException{
                if((char)c != 'A' && (char)c != 'a'){
                    outputWriter.write(c);
                }
            }
        };
    }
    
}
