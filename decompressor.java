// deCompressor 
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException{
        // file directory to store the parent address
        String fileDirectory = file.getParent();
        
        // Input file stream for taking an input
        FileInputStream fis = new FileInputStream(file);
        
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        
        // output file stream
        FileOutputStream fos = new FileOutputStream(fileDirectory +"/Decompressedfilecheck ");
        
        // creating the byte array to store the file size
        byte [] buffer = new byte [1024];
        int length;
        
        // Iterating over the file and keepin in mind there is no loss of the data
        while((length = gzipIS.read(buffer))!=-1){
            System.out.println("Length of File ="+ length);
            fos.write(buffer,0,length);
        }
        
        // closing
        gzipIS.close();
        fis.close();
        fos.close();
    }
// GZIPInputStream
    public static void main(String[] args) throws IOException {
        File path = new File("F:\\documents.gz");
        method(path);
    }
}


