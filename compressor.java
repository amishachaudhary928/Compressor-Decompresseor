// compressordecompressor


package compressordecompressor;

//import static com.mycompany.compressordecompressor.decompressor.method;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method(File file)throws IOException{
        
        // file directory to store the address of that file present
        String fileDirectory = file.getParent();
        
        // To take file as input from the system
        FileInputStream fis = new FileInputStream(file);
        
        // output file stream
        FileOutputStream fos = new  FileOutputStream(fileDirectory+"/ compressed.gz");
        
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        // to store the byte of that file
        byte [] buffer = new byte [1024];
        int length;
        // storing the size of file so that we can insure there is no loss of data
        while((length=fis.read(buffer))!=-1){
            gzip.write(buffer, 0, length);
        }
        // closing...
        fis.close();
        fos.close();
        gzip.close();
    }
    
    // Main function
    
    public static void main(String [] args) throws IOException{
        File path = new File("F:\\documents.gz");
        method(path);
    }
    
}