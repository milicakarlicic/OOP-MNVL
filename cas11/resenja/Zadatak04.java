package cas11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Zadatak04 {

    public static void main(String[] args) {
        Path putanja = Paths.get("src", "cas11", "1.txt");

        try (FileChannel kanal = FileChannel.open(putanja);) {
            // 10 bajtova
            int kapacitet = 10;
            ByteBuffer bafer = ByteBuffer.allocate(kapacitet);

            System.out.println(bafer);

            int rez = kanal.read(bafer);
            if (rez != 10) {
                System.exit(-1);
            }

            System.out.println(bafer);
            bafer.rewind();
            System.out.println(bafer);

            while (bafer.hasRemaining()) {
                byte b = bafer.get();
                System.out.print((char) b);
            }
            System.out.println();

        } catch (IOException e) {
            System.err.println("greskaaa");
        }
    }
}
