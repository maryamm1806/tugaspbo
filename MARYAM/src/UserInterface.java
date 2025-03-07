import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {


  public static void main(String[] args) {
    Database db = new Database();
    ArrayList<Database> data1= new ArrayList<>();
    System.out.println("\n ------ WELCOME TO CRUD SIMPEL -------- ");
    while (true) {
      db.tampilkanMenu();
      Scanner sc = new Scanner(System.in);
      System.out.print("Pilih : ");
      String pilihan = sc.nextLine();
      pilihan = pilihan.toUpperCase();

      switch (pilihan) {
        case "C":
          System.out.println("NOTE : kamu memilih CREATE");
          System.out.println("------------------------------------------------");
          System.out.println("INPUT DATA BARU");
          System.out.print("NIM           : ");
          String nim = sc.nextLine();
          System.out.print("NAMA          : ");
          String nama = sc.nextLine();
          System.out.print("ALAMAT        : ");
          String alamat = sc.nextLine();
          System.out.print("SEMESTER      : ");
          int semester = sc.nextInt();
          System.out.print("SKS           : ");
          int sks = sc.nextInt();
          System.out.print("IPK           : ");
          double ipk = sc.nextDouble();
          sc.nextLine();
          System.out.println("-----------------------------------------------");
          boolean status = db.insert(nim, nama, alamat, semester, sks, ipk);
          if (status == true) {
            System.out.println("DATA BARU BERHASIL DITAMBAHKAN");
          } else {
            System.out.println("NIM " + nim + " sudah ada di database");
            System.out.println("GAGAL MENAMBAHKAN DATA BARU");
          }
          System.out.println("-----------------------------------------------");
          break;
        case "R":
          System.out.println("NOTE : kamu memilih READ");
          db.view();
          break;

        case "U" :
          System.out.println("NOTE : kamu memilih Update");
          db.view();
          System.out.print("NIM Mahasiswa yang akan di update : ");
          String key = sc.nextLine();
          int index = db.search(key);

          if (index >= 0) {
//            boolean status = true;
            System.out.println("kamu akan meng-update data " + db.getData().get(index));
            System.out.println("--------------------------------------------");
            System.out.println("MENGINPUT DATA BARU");
            System.out.print("NIM           : ");
            nim = sc.nextLine();
            System.out.print("NAMA          : ");
            nama = sc.nextLine();
            System.out.print("ALAMAT        : ");
            alamat = sc.nextLine();
            System.out.print("SEMESTER      : ");
            semester = sc.nextInt();
            System.out.print("SKS           : ");
            sks = sc.nextInt();
            System.out.print("IPK           : ");
            ipk = sc.nextDouble();
            sc.nextLine();
            System.out.println("---------------------------------------------");
            status = db.update(index, nim, nama, alamat, semester, sks, ipk);
            if (status == true) {
              System.out.println("DATA BERHASIL DIPERBAHARUI");

            }
            System.out.println("---------------------------------------------");

          } else {
            System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di database");
          }


          break;
        case "D":
          System.out.println("NOTE : kamu memilih DELETE");
          db.view();
          System.out.print("NIM Mahasiswa yang akan di hapus : ");
          key = sc.nextLine();
          index = db.search(key);
          if (index >= 0) {
            System.out.println("APAKAH KAMU YAKIN AKAN MENGHAPUS DATA " + db.getData().get(index) + " ? \nY/N");
            System.out.print("Pilih : ");
            pilihan = sc.nextLine();
            if (pilihan.equalsIgnoreCase("y")) {
              status = db.delete(index);
              if (status == true) {
                System.out.println("DATA BERHASIL DIHAPUS");

              } else {
                System.err.println("GAGAL MENGHAPUS DATA");

              }
            }
          } else {
            System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di database");
          }
          break;


        case "X":

          System.out.println("NOTE : kamu memilih EXIT");
          System.out.println("APAKAH KAMU YAKIN AKAN KELUAR DARI APLIKASI? Y/N");
          System.out.print("Pilih : ");
          pilihan = sc.nextLine();
          if (pilihan.equalsIgnoreCase("Y")) {
            System.exit(0);
          }
          break;
      }


    }
  }
}

