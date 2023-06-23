import java.util.Scanner;

public class KalkulatorMatrix {
    public static void bacaMatriks(int[][] matriks, Scanner input) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                System.out.print("Masukkan elemen [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriks[i][j] = input.nextInt();
            }
        }
    }

    public static void cetakMatriks(int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[0].length; j++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] tambahMatriks(int[][] matriks1, int[][] matriks2) {
        int[][] hasil = new int[matriks1.length][matriks1[0].length];
        for (int i = 0; i < matriks1.length; i++) {
            for (int j = 0; j < matriks1[0].length; j++) {
                hasil[i][j] = matriks1[i][j] + matriks2[i][j];
            }
        }
        return hasil;
    }

    public static int[][] kurangMatriks(int[][] matriks1, int[][] matriks2) {
        int[][] hasil = new int[matriks1.length][matriks1[0].length];
        for (int i = 0; i < matriks1.length; i++) {
            for (int j = 0; j < matriks1[0].length; j++) {
                hasil[i][j] = matriks1[i][j] - matriks2[i][j];
            }
        }
        return hasil;
    }

    public static int[][] kaliMatriks(int[][] matriks1, int[][] matriks2) {
        int[][] hasil = new int[matriks1.length][matriks2[0].length];
        for (int i = 0; i < matriks1.length; i++) {
            for (int j = 0; j < matriks2[0].length; j++) {
                for (int k = 0; k < matriks1[0].length; k++) {
                    hasil[i][j] += matriks1[i][k] * matriks2[k][j];
                }
            }
        }
        return hasil;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ulangInput;
        do {
            System.out.print("\nMasukkan jumlah baris matriks: ");
            int baris = input.nextInt();

            System.out.print("Masukkan jumlah kolom matriks: ");
            int kolom = input.nextInt();

            int[][] matriks1 = new int[baris][kolom];
            int[][] matriks2 = new int[baris][kolom];
            int[][] hasil = new int[baris][kolom];

            System.out.println("\nOperasi yang tersedia: ");
            System.out.println("1. Input Matrix ");
            System.out.println("2. Penjumlahan matriks");
            System.out.println("3. Pengurangan matriks");
            System.out.println("4. Perkalian matriks");
            System.out.print("Pilih operasi (1/2/3/4): ");
            int pilihan = input.nextInt();
            if (pilihan == 1) {
                System.out.println("\nMasukkan elemen-elemen matriks pertama:");
                bacaMatriks(matriks1, input);

                System.out.println("Masukkan elemen-elemen matriks kedua:");
                bacaMatriks(matriks2, input);

                System.out.println("\nOperasi yang tersedia: ");
                System.out.println("1. Penjumlahan matriks");
                System.out.println("2. Pengurangan matriks");
                System.out.println("3. Perkalian matriks");
                System.out.print("Pilih operasi (1/2/3): ");
                int pilihanOperasi = input.nextInt();

                switch (pilihanOperasi) {
                    case 1 -> {
                        hasil = tambahMatriks(matriks1, matriks2);
                        System.out.println("Hasil penjumlahan matriks:");
                    }
                    case 2 -> {
                        hasil = kurangMatriks(matriks1, matriks2);
                        System.out.println("Hasil pengurangan matriks:");
                    }
                    case 3 -> {
                        hasil = kaliMatriks(matriks1, matriks2);
                        System.out.println("Hasil perkalian matriks:");
                    }
                    default -> {
                        System.out.println("Pilihan yang Anda masukkan tidak valid.");
                        break;
                    }
                }
                cetakMatriks(hasil);
                System.out.print("\nUlang Operasi? (Y/n) : ");
                ulangInput = input.next();
            } else {
                System.out.println("Pilihan yang Anda masukkan tidak valid.");
                break;
            }

            }while (ulangInput.equalsIgnoreCase("Y"));
            System.out.println("<== QUIT!");
        }
    }

